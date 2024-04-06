package com.example.examplecalcul;

import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import org.mariuszgromada.math.mxparser.*;

public class MainActivity extends AppCompatActivity {

    private EditText display;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout);

        // Initialisation du champ de texte
        display = findViewById(R.id.textView);
        display.setShowSoftInputOnFocus(false);

        // Gestion du clic sur le champ de texte pour effacer le texte par défaut
        display.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (getString(R.string.display).equals(display.getText().toString())) {
                    display.setText(""); // Efface le texte par défaut
                }
            }
        });
    }

    // Méthode pour mettre à jour le texte du champ de texte
    private void updateText(String strToAdd) {
        String oldStr = display.getText().toString();
        int cursorPos = display.getSelectionStart();
        String leftStr = oldStr.substring(0, cursorPos);
        String rightStr = oldStr.substring(cursorPos);
        if (getString(R.string.display).equals(display.getText().toString())) {
            display.setText(strToAdd); // Remplace le texte par le caractère à ajouter
        } else {
            display.setText(String.format("%s%s%s", leftStr, strToAdd, rightStr));
            display.setSelection(cursorPos + 1); // Déplace le curseur après le caractère ajouté
        }
    }

    // Méthodes pour les boutons numériques

    // Ajoute le chiffre 0
    public void zeroBTN(View view) {
        updateText("0");
    }

    // Ajoute le chiffre 1
    public void oneBTN(View view) {
        updateText("1");
    }

    // Ajoute le chiffre 2
    public void twoBTN(View view) {
        updateText("2");
    }

    // Ajoute le chiffre 3
    public void threeBTN(View view) {
        updateText("3");
    }

    // Ajoute le chiffre 4
    public void fourBTN(View view) {
        updateText("4");
    }

    // Ajoute le chiffre 5
    public void fiveBTN(View view) {
        updateText("5");
    }

    // Ajoute le chiffre 6
    public void sixBTN(View view) {
        updateText("6");
    }

    // Ajoute le chiffre 7
    public void sevenBTN(View view) {
        updateText("7");
    }

    // Ajoute le chiffre 8
    public void eightBTN(View view) {
        updateText("8");
    }

    // Ajoute le chiffre 9
    public void nineBTN(View view) {
        updateText("9");
    }

    // Méthodes pour les opérations mathématiques

    // Ajoute l'opérateur d'addition
    public void addBTN(View view) {
        updateText("+");
    }

    // Ajoute l'opérateur de soustraction
    public void plusminusBTN(View view) {
        updateText("-");
    }

    // Efface le contenu du champ de texte
    public void clearBTN(View view) {
        display.setText("");
    }

    // Gestion des parenthèses
    public void paranthesesBTN(View view) {
        // Logique à expliquer plus en détail
    }

    // Ajoute l'opérateur d'exponentiation
    public void exponentBTN(View view) {
        updateText("^");
    }

    // Ajoute l'opérateur de division
    public void divideBTN(View view) {
        updateText("÷");
    }

    // Ajoute l'opérateur de multiplication
    public void multiplyBTN(View view) {
        updateText("×");
    }

    // Ajoute l'opérateur de soustraction
    public void minusBTN(View view) {
        updateText("-");
    }

    // Ajoute le point décimal
    public void dotBTN(View view) {
        updateText(".");
    }

    // Méthode pour supprimer le dernier caractère
    public void backspaceBTN(View view) {
        int cursorPos = display.getSelectionStart();
        int textLen = display.getText().length();

        if (cursorPos != 0 && textLen != 0) {
            SpannableStringBuilder selection = (SpannableStringBuilder) display.getText();
            selection.replace(cursorPos - 1, cursorPos, ""); // Supprime le dernier caractère
            display.setText(selection);
            display.setSelection(cursorPos - 1);
        }
    }

    // Méthode pour évaluer l'expression mathématique
    public void equalsBTN(View view) {
        String userExp = display.getText().toString();

        userExp = userExp.replaceAll("÷", "/"); // Remplace le symbole de division
        userExp = userExp.replaceAll("×", "*"); // Remplace le symbole de multiplication

        Expression exp = new Expression(userExp);
        String result = String.valueOf(exp.calculate()); // Calcule le résultat de l'expression

        display.setText(result);
        display.setSelection(result.length());
    }
}
