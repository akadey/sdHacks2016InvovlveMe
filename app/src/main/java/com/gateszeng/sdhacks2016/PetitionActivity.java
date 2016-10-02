package com.gateszeng.sdhacks2016;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.docusign.esign.api.*;
import com.docusign.esign.client.*;
import com.docusign.esign.model.*;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;

import java.util.ArrayList;

import com.firebase.client.Firebase;

public class PetitionActivity extends AppCompatActivity {
    //change
    Firebase rootRef = new Firebase("https://sdhacks2016-11cfe.firebaseio.com/");



    private String userName;
    private String userEmail;
    private String userSchool;
    private String petitiondesc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_petition);

        GoogleSignInAccount acct = getIntent().getParcelableExtra("googleaccount");
        userName = acct.getDisplayName();
        userEmail = acct.getEmail();
        userSchool = getIntent().getStringExtra("schoolname");


        // Get the petition description from the extra and set the text view's description
        petitiondesc = getIntent().getStringExtra("petitiondescription");
        if(petitiondesc != null) {
            ((TextView) findViewById(R.id.petitiondescription)).setText(petitiondesc);
        }
        ((TextView)findViewById(R.id.petitiondescription)).setText(userSchool);

        // Wait to show layout until its loaded
        ((LinearLayout)findViewById(R.id.LL)).setVisibility(View.VISIBLE);
    }

    public void goToDocuSign(View v) {
        ((TextView)findViewById(R.id.petitiondescription)).setText("GOING TO DOCUSIGN");
        String username = "lukethethomas@gmail.com";
        String password = "mewtwo101";
        String integratorKey = "02b3db51-5178-42c3-8498-0c724bd9f393";

        // initialize client for desired environment and add X-DocuSign-Authentication header
        ApiClient apiClient = new ApiClient();
        apiClient.setBasePath("https://demo.docusign.net/restapi");

        // configure 'X-DocuSign-Authentication' authentication header
        String authHeader = "{\"Username\":\"" +  username + "\",\"Password\":\"" +  password +
                "\",\"IntegratorKey\":\"" +  integratorKey + "\"}";
        apiClient.addDefaultHeader("X-DocuSign-Authentication", authHeader);
        Configuration.setDefaultApiClient(apiClient);

        try
        {

            /////////////////////////////////////////////////////////////////////////////////////////////////////////
            // STEP 1: LOGIN API
            /////////////////////////////////////////////////////////////////////////////////////////////////////////
            AuthenticationApi authApi = new AuthenticationApi();
            LoginInformation loginInfo = authApi.login();

            // parse first account ID (user might belong to multiple accounts)
            String accountId = loginInfo.getLoginAccounts().get(0).getAccountId();

            /////////////////////////////////////////////////////////////////////////////////////////////////////////
            // *** STEP 2: CREATE ENVELOPE FROM TEMPLATE
            /////////////////////////////////////////////////////////////////////////////////////////////////////////

            // create a new envelope to manage the signature request
            EnvelopeDefinition envDef = new EnvelopeDefinition();
            envDef.setEmailSubject("School petition");

            // assign template information including ID and role(s)
            envDef.setTemplateId("4310f230-ffdd-4171-a5e1-b75d3a23a74f");

            // create a template role with a valid templateId and roleName and assign signer info
            TemplateRole tRole = new TemplateRole();
            tRole.setRoleName("supporter");
            tRole.setName(userName);
            tRole.setEmail(userEmail);

            // create a list of template roles and add our newly created role
            java.util.List<TemplateRole> templateRolesList = new ArrayList<TemplateRole>();
            templateRolesList.add(tRole);

            // assign template role(s) to the envelope
            envDef.setTemplateRoles(templateRolesList);

            // send the envelope by setting |status| to "sent". To save as a draft set to "created"
            envDef.setStatus("sent");

            // instantiate a new EnvelopesApi object
            EnvelopesApi envelopesApi = new EnvelopesApi();

            // call the createEnvelope() API
            EnvelopeSummary envelopeSummary = envelopesApi.createEnvelope(accountId, envDef);
        }
        catch (com.docusign.esign.client.ApiException ex)
        {
            System.out.println("Exception: " + ex);
        }
        setContentView(R.layout.activity_create_petition);


        String emergencyPost = "";
        String authorPost = "";


        Firebase postsRef = rootRef.child("posts");
        Firebase currAuthor = postsRef.child(authorPost);



        currAuthor.child("post").setValue(emergencyPost);
    }
}
