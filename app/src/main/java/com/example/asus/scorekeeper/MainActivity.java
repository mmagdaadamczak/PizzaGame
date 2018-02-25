package com.example.asus.scorekeeper;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    int scorePlayerOne = 0;
    int scorePlayerTwo = 0;
    int pizzaCounterPlayerOne = 0;
    int beerCounterPlayerOne = 0;
    int pizzaCounterPlayerTwo = 0;
    int beerCounterPlayerTwo = 0;
    TextView playerOneScore;
    TextView playerTwoScore;
    TextView displayedText;
    TextView appLogo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_main );
        playerOneScore = findViewById ( R.id.player_one_score );
        playerTwoScore = findViewById ( R.id.player_two_score );
        displayedText = findViewById ( R.id.displayed_text );
        appLogo = findViewById ( R.id.app_logo );
    }


    /**
     * Increase the score for Player One, when he hit pizza button and count button clicks.
     */

    public void pizzaForPlayerOne(View view) {
        pizzaCounterPlayerOne += 1;
        scorePlayerOne += 4;
        if (pizzaCounterPlayerOne >= 15) {
            displayCustomText ( getString ( R.string.to_much_pizza ) );
        } else displayCustomText ( "" );
        displayScorePlayerOne ( scorePlayerOne );
    }


    /**
     * Increase the score for Player One, when he hit cheese button.
     */

    public void cheeseForPlayerOne(View view) {
        displayCustomText ( "" );
        if (scorePlayerOne == 0) {
            Toast myToast = Toast.makeText ( this, getString ( R.string.toast_message ), Toast.LENGTH_SHORT );
            myToast.show ();
            myToast.setGravity ( Gravity.CENTER, 0, 0 );
            return;
        }
        scorePlayerOne += 10;
        Button cheeseButtonOne = findViewById ( R.id.cheese_button_1 );
        cheeseButtonOne.setEnabled ( false );
        cheeseButtonOne.setText ( getString ( R.string.end_of_cheese ) );
        displayScorePlayerOne ( scorePlayerOne );
    }


    /**
     * Decrease the score for Player One, when he hit beer button and count button clicks..
     */

    public void beerForPlayerOne(View view) {
        displayCustomText ( "" );
        if (scorePlayerOne == 0) {
            Toast myToast = Toast.makeText ( this, getString ( R.string.toast_message ), Toast.LENGTH_SHORT );
            myToast.show ();
            myToast.setGravity ( Gravity.CENTER, 0, 0 );
            return;
        }
        scorePlayerOne -= 1;
        beerCounterPlayerOne += 1;
        ImageView beerImage = findViewById ( R.id.beer_button_1 );
        if (beerCounterPlayerOne == 10) {
            displayCustomText ( getString ( R.string.to_much_alco ) );
            beerImage.setEnabled ( false );
            beerImage.setImageResource ( R.drawable.ic_no_alcohol );
        }
        if (scorePlayerOne == 0) {
            beerImage.setEnabled ( false );
            displayScorePlayerOne ( 0 );
        }
        displayScorePlayerOne ( scorePlayerOne );
    }


    /**
     * Increase the score for Player Two, when he hit pizza button.
     */

    public void pizzaForPlayerTwo(View view) {
        pizzaCounterPlayerTwo += 1;
        scorePlayerTwo += 4;
        if (pizzaCounterPlayerTwo >= 15) {
            displayCustomText ( getString ( R.string.to_much_pizza ) );
        } else displayCustomText ( "" );
        displayScorePlayerTwo ( scorePlayerTwo );
    }


    /**
     * Increase the score for Player Two, when he hit cheese button.
     */

    public void cheeseForPlayerTwo(View view) {
        displayCustomText ( "" );
        if (scorePlayerTwo == 0) {
            Toast myToast = Toast.makeText ( this, getString ( R.string.toast_message ), Toast.LENGTH_SHORT );
            myToast.show ();
            myToast.setGravity ( Gravity.CENTER, 0, 0 );
            return;
        }
        scorePlayerTwo += 10;
        Button cheeseButtonTwo = findViewById ( R.id.cheese_button_2 );
        cheeseButtonTwo.setEnabled ( false );
        cheeseButtonTwo.setText ( (getString ( R.string.end_of_cheese )) );
        displayScorePlayerTwo ( scorePlayerTwo );
    }


    /**
     * Decrease the score for Player One, when he hit beer button and count button clicks..
     */

    public void beerForPlayerTwo(View view) {
        displayCustomText ( "" );
        if (scorePlayerTwo == 0) {
            Toast myToast = Toast.makeText ( this, getString ( R.string.toast_message ), Toast.LENGTH_SHORT );
            myToast.show ();
            myToast.setGravity ( Gravity.CENTER, 0, 0 );
            return;
        }
        scorePlayerTwo -= 1;
        beerCounterPlayerTwo += 1;
        ImageView beerButton2 = findViewById ( R.id.beer_button_2 );
        if (beerCounterPlayerTwo == 10) {
            displayCustomText ( getString ( R.string.to_much_alco ) );
            beerButton2.setEnabled ( false );
            beerButton2.setImageResource ( R.drawable.ic_no_alcohol );
        }
        if (scorePlayerTwo == 0) {
            beerButton2.setEnabled ( false );
            displayScorePlayerTwo ( 0 );
        }
        displayScorePlayerTwo ( scorePlayerTwo );
    }


    /**
     * End the game
     */

    public void endOfTheGame(View view) {
        if (scorePlayerOne > scorePlayerTwo) {
            displayAppLogo ( getString ( R.string.winner_1 ) );
        } else if (scorePlayerOne == scorePlayerTwo) {
            displayAppLogo ( getString ( R.string.remis ) );
        } else displayAppLogo ( getString ( R.string.winner_2 ) );
        displayCustomText ( getString ( R.string.congratulation ) );
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
        recreate ();
    }


    /**
     * This methods display the main text on the screen.
     */

    public void displayAppLogo(String message) {
        appLogo.setText ( message );
    }


    /**
     * This methods display the given text on the screen below app logo.
     */

    public void displayCustomText(String message) {
        displayedText.setText ( message );
    }


    /**
     * Displays the given score for Player One.
     */

    public void displayScorePlayerOne(int score) {
        playerOneScore.setText ( String.valueOf ( score ) );
    }


    /**
     * Displays the given score for Player Two.
     */

    public void displayScorePlayerTwo(int score) {
        playerTwoScore.setText ( String.valueOf ( score ) );
    }
}


