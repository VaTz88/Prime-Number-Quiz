package in.vatz88.primarynumberquiz;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    int n = 5;

    private void updateNumber(){
        Random rand = new Random();
        n = rand.nextInt(100);

        TextView view = (TextView) findViewById(R.id.number);

        view.setText(Integer.toString(n));
    }

    public void nextQuestion(View view){
        updateNumber();
    }

    public void checkAnswer(View view){
        Context context = getApplicationContext();
        CharSequence message;
        int duration = Toast.LENGTH_SHORT;
        Toast toast;

        if((checkPrime() && ((Button)view == (Button)findViewById(R.id.trueButtonId))) || (!checkPrime() && ((Button)view == (Button)findViewById(R.id.falseButtonId)))){
            message = "Correct";
            toast = Toast.makeText(context,message,duration);
            toast.show();
        }
        else {
            message = "Incorrect";
            toast = Toast.makeText(context,message,duration);
            toast.show();
        }
    }

    boolean checkPrime(){

        int sqrt_of_n= (int) Math.sqrt(n);

        if(n==0||n==1)
            return false;

        for (int i=2;i<=sqrt_of_n;i++){
            if(n%i == 0){
                return false;
            }
        }

        return true;
    }
}
