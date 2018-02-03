package com.example.asus.scorekeeper;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    int scorePlayerOne = 0;
    int scorePlayerTwo = 0;
    int beer = 0;
    int beer1 = 0;
    int pizza = 0;
    int pizza1 = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_main );
    }


    /**
     * Increase the score for Player One, when he hit pizza button and count button clicks.
     */


    public void pizzaForPlayerOne(View view) {
        pizza += 1;
        scorePlayerOne += 4;
        if (pizza >= 15) {
            displayCustomText ( getString ( R.string.to_much_pizza ) );
        } else displayCustomText ( "" );
        displayScorePlayerOne ( scorePlayerOne );
    }

    /**
     * Increase the score for Player One, when he hit cheese button.
     */

    public void cheeseForPlayerOne(View view) {
        scorePlayerOne += 10;
        displayCustomText ( "" );
        findViewById ( R.id.cheese_button_1 ).setEnabled ( false );
        TextView neww = findViewById ( R.id.cheese_button_1 );
        neww.setText ( getString ( R.string.end_of_cheese ) );
        displayScorePlayerOne ( scorePlayerOne );
        return;
    }

    /**
     * Decrease the score for Player One, when he hit beer button and count button clicks..
     */

    public void beerForPlayerOne(View view) {


        if (scorePlayerOne == 0) {
            Toast myToast = Toast.makeText ( this, getString ( R.string.toast_message ), Toast.LENGTH_SHORT );
            myToast.show ();
            myToast.setGravity ( Gravity.CENTER, 0, 0 );
            return;

        }

        scorePlayerOne -= 1;
        beer += 1;

        if (beer == 10) {
            displayCustomText ( getString ( R.string.to_much_alco ) );

            findViewById ( R.id.beer_button_1 ).setEnabled ( false );
            ImageView newImageView1 = findViewById ( R.id.beer_button_1 );
            newImageView1.setImageResource ( R.drawable.ic_no_alcohol );
        }

        if (scorePlayerOne == 0 && pizza == 0) {
            findViewById ( R.id.beer_button_1 ).setEnabled ( false );
            displayScorePlayerOne ( 0 );
        }


        displayScorePlayerOne ( scorePlayerOne );
    }


    /**
     * Increase the score for Player Two, when he hit cheese button.
     */


    public void pizzaForPlayerTwo(View view) {
        pizza1 += 1;
        scorePlayerTwo += 4;
        if (pizza1 >= 15) {
            displayCustomText ( getString ( R.string.to_much_pizza ) );
        } else displayCustomText ( "" );

        displayScorePlayerTwo ( scorePlayerTwo );

    }


    public void cheeseForPlayerTwo(View view) {
        scorePlayerTwo += 10;
        displayCustomText ( "" );
        findViewById ( R.id.cheese_button_2 ).setEnabled ( false );
        TextView neww2 = findViewById ( R.id.cheese_button_2 );
        neww2.setText ( (getString ( R.string.end_of_cheese )) );
        displayScorePlayerTwo ( scorePlayerTwo );
        return;
    }


    public void beerForPlayerTwo(View view) {
        displayCustomText ( "" );
        if (scorePlayerTwo == 0) {
            Toast myToast = Toast.makeText ( this, getString ( R.string.toast_message ), Toast.LENGTH_SHORT );
            myToast.show ();
            myToast.setGravity ( Gravity.CENTER, 0, 0 );
            return;
        }


        scorePlayerTwo -= 1;
        beer1 += 1;


        if (beer1 == 10) {
            displayCustomText ( getString ( R.string.to_much_alco ) );
            findViewById ( R.id.beer_button_2 ).setEnabled ( false );
            ImageView newImageView1 = findViewById ( R.id.beer_button_2 );
            newImageView1.setImageResource ( R.drawable.ic_no_alcohol );
        }

        if (scorePlayerTwo == 0 && pizza1 == 0) {
            findViewById ( R.id.beer_button_2 ).setEnabled ( false );
            displayScorePlayerTwo ( 0 );
        }

        displayScorePlayerTwo ( scorePlayerTwo );

    }


    public void endOfTheGame(View view) {

        if (scorePlayerOne > scorePlayerTwo) {
            displayAppLogo ( getString ( R.string.winner_1 ) );
        } else if (scorePlayerOne == scorePlayerTwo) {
            displayAppLogo ( getString ( R.string.remis ) );
        } else displayAppLogo ( getString ( R.string.winner_2 ) );

        displayCustomText ( getString ( R.string.congratulation ) );
        displayScorePlayerOne ( scorePlayerOne );
        displayScorePlayerTwo ( scorePlayerTwo );
        findViewById ( R.id.cheese_button_1 ).setEnabled ( false );
        findViewById ( R.id.cheese_button_2 ).setEnabled ( false );
        findViewById ( R.id.beer_button_1 ).setEnabled ( false );
        findViewById ( R.id.beer_button_2 ).setEnabled ( false );
        findViewById ( R.id.pizza_buton_1 ).setEnabled ( false );
        findViewById ( R.id.pizza_button_2 ).setEnabled ( false );


    }


    /**
     * Resets the score for both teams back to 0.
     */

    public void Reset(View view) {
        scorePlayerOne = 0;
        scorePlayerTwo = 0;
        beer = 0;
        beer1 = 0;
        pizza = 0;
        pizza1 = 0;
        displayScorePlayerOne ( scorePlayerOne );
        displayScorePlayerTwo ( scorePlayerTwo );
        displayAppLogo ( getString ( R.string.app_name ) );
        String startMessage = getString ( R.string.let_s_start );
        displayCustomText ( startMessage );
        findViewById ( R.id.cheese_button_1 ).setEnabled ( true );
        findViewById ( R.id.cheese_button_2 ).setEnabled ( true );
        findViewById ( R.id.beer_button_1 ).setEnabled ( true );
        findViewById ( R.id.beer_button_2 ).setEnabled ( true );
        findViewById ( R.id.pizza_button_2 ).setEnabled ( true );
        findViewById ( R.id.pizza_buton_1 ).setEnabled ( true );

        ImageView newImageView = findViewById ( R.id.pizza_buton_1 );
        newImageView.setImageResource ( R.drawable.ic_pizza1 );
        ImageView newImageView1 = findViewById ( R.id.pizza_button_2 );
        newImageView1.setImageResource ( R.drawable.ic_pizza3s );
        ImageView newImageView2 = findViewById ( R.id.beer_button_1 );
        newImageView2.setImageResource ( R.drawable.ic_beer3 );
        ImageView newImageView3 = findViewById ( R.id.beer_button_2 );
        newImageView3.setImageResource ( R.drawable.ic_pint_of_beer );
        TextView neww = findViewById ( R.id.cheese_button_1 );
        neww.setText ( R.string.cheese_button );
        TextView neww2 = findViewById ( R.id.cheese_button_2 );
        neww2.setText ( R.string.cheese_button );
        TextView neww4 = findViewById ( R.id.displayed_text );


    }


    /**
     * This methods display the main text on the screen.
     */

    public void displayAppLogo(String message) {
        TextView priceTextView = findViewById ( R.id.app_logo );
        priceTextView.setText ( message );
    }

    /**
     * This methods display the given text on the screen below app logo.
     */


    public void displayCustomText(String message) {
        TextView newTextView = findViewById ( R.id.displayed_text );
        newTextView.setText ( message );
    }


    /**
     * Displays the given score for Player One.
     */

    public void displayScorePlayerOne(int score) {
        TextView scoreView = findViewById ( R.id.player_one_score );
        scoreView.setText ( String.valueOf ( score ) );

    }


    /**
     * Displays the given score for Player Two.
     */


    public void displayScorePlayerTwo(int score) {
        TextView scoreView = findViewById ( R.id.player_two_score );
        scoreView.setText ( String.valueOf ( score ) );

    }
}


