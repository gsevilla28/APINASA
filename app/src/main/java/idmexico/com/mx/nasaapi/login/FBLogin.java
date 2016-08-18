package idmexico.com.mx.nasaapi.login;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

import butterknife.BindView;
import butterknife.ButterKnife;
import idmexico.com.mx.nasaapi.ListingActivity;
import idmexico.com.mx.nasaapi.R;

public class FBLogin extends AppCompatActivity implements FacebookCallback<LoginResult>{

    private CallbackManager callbackManager;
    @BindView(R.id.fb_login_button)
    LoginButton loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fblogin);

        ButterKnife.bind(this);

        callbackManager = CallbackManager.Factory.create();
        loginButton.registerCallback(callbackManager,this);


        if (AccessToken.getCurrentAccessToken() !=null){
            Snackbar.make(findViewById(android.R.id.content),"PRELOGIN",Snackbar.LENGTH_SHORT);
            startActivity( new Intent(this, ListingActivity.class));
        }



    }

    @Override
    public void onSuccess(LoginResult loginResult) {
        Snackbar.make(findViewById(android.R.id.content),"PRELOGIN-on success",Snackbar.LENGTH_SHORT);
        startActivity( new Intent(this, ListingActivity.class));
    }

    @Override
    public void onCancel() {

    }

    @Override
    public void onError(FacebookException error) {

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode, resultCode,data);
    }
}
