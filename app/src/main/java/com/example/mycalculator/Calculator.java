// Eric Chen
// ID: 89351145

package com.example.mycalculator;
import java.text.DecimalFormat;

public class Calculator {
    String[] arithmetic; // array to store numbers for PEMDAS and operations that are used
    int arrayindex; // index of array that is on
    //two numbers used in operation
    int inputflag;  // flag to check if theres no number put
    int errorflag; // flag to check if error, 0 power 0, divide by 0
    int decimalpressflag; // flag to check if decimal button is pressed / 1 if pressed, so will add the decimal / 2 if decimal is added already
    int decimalzeros; // how many 0s are pressed after a decimal ex. 0.00000001
    int selectflag; // flag to check if currently selecting operation
    String logrootsquareflag; // flag to check if pressed log, root or square, will be default a if nothing
    double prev_num; // previous number
    double curr_num;  // current number that is about to be put an operation on, SAME PRIOIRTY NUMBER
    double new_num;    // number that is inputted
    double displaynum; // num that will be displayed
    int prev_op; // previous operation priotiy , add - 1, mult - 2, power - 3
    int curr_op; // current operation priority
    String prev_op_string_actual; // actual previous operation
    String prev_op_string; // string of previous op clicked
    DecimalFormat df = new DecimalFormat("0.#########");
    DecimalFormat overflow = new DecimalFormat("#.######E0"); // use this format when number overflow
    //operation variable
    int clearflag; // clear flag check if clear
    //actual text space, showing numbers
    //tool to help round numbers to 7 decimals
    //constructor
    public Calculator(){
        this.curr_num = 0;
        this.prev_num = 0;
        this.inputflag = 0;
        this.displaynum = 0;
        this.errorflag = 0;
        this.prev_op = 0;
        this.curr_op = 0; //higher cuz start
        this.decimalzeros = 0;
        this.prev_op_string_actual = "a";
        this.prev_op_string = "a";
        this.arithmetic = new String[8];
        this.arrayindex = 0;
        this.clearflag = 1;
        this.selectflag = 0;
        this.logrootsquareflag = "a";
        this.decimalpressflag = 0;
        this.arithmetic[arrayindex] = "0";
        this.arithmetic[arrayindex+1] = "+";
        this.arithmetic[arrayindex+2] = "0";
    }
    // num buttons
    public String btn0 () {
        String fullstring;
        int currentzeros = this.decimalzeros;  // how many zeros are stored first
        // error when divide by 0, and also power 0
        this.new_num = numberSet(0);
        if ((this.prev_op_string_actual == "/" && this.new_num == 0) || (this.prev_op_string_actual == "^" && this.new_num == 0 && this.prev_num == 0)){
            errorflag = 1;
        }
        // put a decimal in the number if it does not have a decimal ending and clicked decimal press flag
        if (this.new_num % 1 == 0 && decimalpressflag == 2){
            fullstring = ".";
        }
        else{
            fullstring = "";
        }
        // if there is a decimal press confirmed after the current number, then increment 0s until next nonzero number is pressed, and then show the 0s after
        if (countNum(this.new_num) < 10 && decimalpressflag == 2){
            this.decimalzeros++;
            for (int i = 0; i < this.decimalzeros; i++){
                fullstring = fullstring + "0";
            }
            // dont overflow decimals, goes back to same
            if (countNum(this.new_num) + this.decimalzeros > 9){
                this.decimalzeros = currentzeros;
            }
            return df.format(this.new_num) + fullstring;
        }
        return df.format(this.new_num);
    }
    // sets number
    public String btnnum (int n) {
        this.new_num = numberSet(n);
        return df.format(this.new_num);
    }

    public double numberSet(int n){
        // array index goes up
        // if just cleared, prev operation string is + because of 0
        this.selectflag = 0;
        this.prev_op_string_actual = this.prev_op_string;
        if (this.clearflag == 1){
            this.clearflag = 0;
            this.prev_op = 0;
            this.curr_op = 0;
        }
        this.curr_num = this.displaynum;
        // if the current operation is bigger than previous and its the first input
        if (this.curr_op > this.prev_op && this.inputflag == 0){
            this.arrayindex+=2;
        }
        if (this.inputflag == 0){
            // get previous number from display
            this.prev_num = this.curr_num;
            // operation is used so goes to previous
            this.prev_op = this.curr_op;
            // if decimal flag, then add 0. + decimal
            if (this.decimalpressflag == 1){
                this.new_num = Double.parseDouble(df.format(this.new_num) + "." + n);
                this.decimalpressflag = 2;
            }
            else{
                this.new_num = n;
            }
            this.inputflag++;
            this.selectflag = 0;
            return this.new_num;
        }
        if (countNum(this.new_num) > 10){
            return this.new_num;
        }
        if (this.inputflag >= 1 || this.decimalzeros > 0 ){ // if there is an input, (or if there are zeros after a decimal) it will concatenate integers
            // if decimal flag, then concatenate decimal
            if (this.decimalpressflag == 1){
                this.new_num = Double.parseDouble(df.format(this.new_num) + "." + n);
                this.decimalpressflag = 2;
            }
            else if (this.decimalpressflag == 2 ){
                String zerostring;
                // put a decimal in the number if it does not have a decimal ending and clicked decimal press flag
                if (this.new_num % 1 == 0){
                    zerostring = ".";
                }
                else{
                    zerostring = "";
                }
                for (int i = 0; i < this.decimalzeros; i++){
                    zerostring = zerostring + "0";
                }
                this.new_num = Double.parseDouble(df.format(this.new_num) + zerostring + n);
                if (n != 0){
                    this.decimalzeros = 0;
                }
            }
            else{
                this.new_num = Double.parseDouble(df.format(this.new_num) + n);
            }
            return this.new_num;
        }
        return 0;
    }
    // count how many digits in displaynum, returns 1 if too many number, will return 0 when 10 in display
    public int countNum(double n){
        int digit = 0;
        String numstring = String.valueOf(n);
        for (int i = 0; i < numstring.length(); i++){
            if (numstring.charAt(i) >= 48 && numstring.charAt(i) <= 57){
                digit++;
            }
        }
        return digit;
    }
    // priority 1
    public String btnadd () {
        // set the log for next time
        if (this.logrootsquareflag != "a" && selectflag == 0){
            if (returnLogrootsquare(this.logrootsquareflag) == "Error"){
                return "Error";
            }
            this.logrootsquareflag = "a";
        }
        this.decimalpressflag = 0;
        this.selectflag = 1;
        this.prev_op_string = "+";
        this.inputflag = 0;
        this.curr_op = 0;               // priority
        // error because previois was divide 0
        if (errorflag == 1) {
            return "Error";
        }
        this.arithmetic[arrayindex] = String.valueOf(this.curr_num);
        this.arithmetic[arrayindex+1] = prev_op_string_actual;
        this.arithmetic[arrayindex+2] = String.valueOf(this.new_num);
        doPreviousOperations(0);
        if (this.displaynum / 100000000 > 1){
            return overflow.format(this.displaynum);
        }
        else{
            return df.format(this.displaynum);
        }
    }
    public String btnsubtract () {
        // set the log for next time
        if (this.logrootsquareflag != "a" && selectflag == 0){
            if (returnLogrootsquare(this.logrootsquareflag) == "Error"){
                return "Error";
            }
            this.logrootsquareflag = "a";
        }
        this.decimalpressflag = 0;
        this.selectflag = 1;
        this.prev_op_string = "-";
        this.inputflag = 0;
        this.curr_op = 0;               // priority
        if (errorflag == 1) {
            return "Error";
        }
        // do previous operations in the array if prioirty is lower
        this.arithmetic[arrayindex] = String.valueOf(this.curr_num);
        this.arithmetic[arrayindex+1] = prev_op_string_actual;
        this.arithmetic[arrayindex+2] = String.valueOf(this.new_num);
        doPreviousOperations(0);
        if (countNum(this.displaynum) / 100000000 > 1){
            return overflow.format(this.displaynum);
        }
        else{
            return df.format(this.displaynum);
        }
    }

    // priority 2
    public String btnmultiply () {
        // set the log for next time
        if (this.logrootsquareflag != "a" && selectflag == 0){
            if (returnLogrootsquare(this.logrootsquareflag) == "Error"){
                return "Error";
            }
            this.logrootsquareflag = "a";
        }
        this.decimalpressflag = 0;
        this.selectflag = 1;
        // temporary variable to hold the previous number
        this.prev_op_string = "*";
        this.inputflag = 0;
        this.curr_op = 1;               // priority
        if (errorflag == 1) {
            return "Error";
        }
        this.arithmetic[arrayindex] = String.valueOf(this.curr_num);
        this.arithmetic[arrayindex+1] = prev_op_string_actual;
        this.arithmetic[arrayindex+2] = String.valueOf(this.new_num);
        // if this pripority is lower than old, execute everything now (execute based on priority)
        if (this.prev_op >= 1){
            doPreviousOperations(1);
            // set null cuz random inputs
        }
        else{
            // if this priority is higher put previous operation and number inside array
            this.displaynum = this.new_num;
        }
        if (this.displaynum / 100000000 > 1){
            return overflow.format(this.displaynum);
        }
        else{
            return df.format(this.displaynum);
        }
    }
    // cant divide by 0
    public String btndivide () {
        // set the log for next time
        if (this.logrootsquareflag != "a" && selectflag == 0){
            if (returnLogrootsquare(this.logrootsquareflag) == "Error"){
                return "Error";
            }
            this.logrootsquareflag = "a";
        }
        this.decimalpressflag = 0;
        this.selectflag = 1;
        // temporary variable to hold the previous number
        this.prev_op_string = "/";
        this.inputflag = 0;
        this.curr_op = 1;               // priority
        if (errorflag == 1) {
            return "Error";
        }
        this.arithmetic[arrayindex] = String.valueOf(this.curr_num);
        this.arithmetic[arrayindex+1] = prev_op_string_actual;
        this.arithmetic[arrayindex+2] = String.valueOf(this.new_num);
        // if this pripority is lower than old, execute everything now (execute based on priority)
        if (this.prev_op >= 1){
            doPreviousOperations(1);
            // set null cuz random inputs
        }
        else{
            // if this priority is higher put previous operation and number inside array
            this.displaynum = this.new_num;
        }
        if (this.displaynum / 100000000 > 1){
            return overflow.format(this.displaynum);
        }
        else{
            return df.format(this.displaynum);
        }
    }
    // highest prioirty, power PEMDAS
    public String btnpower () {
        // set the log for next time
        if (this.logrootsquareflag != "a" && selectflag == 0){
            if (returnLogrootsquare(this.logrootsquareflag) == "Error"){
                return "Error";
            }
            this.logrootsquareflag = "a";
        }
        this.decimalpressflag = 0;
        this.selectflag = 1;
        // temporary variable to hold the previous number
        this.prev_op_string = "^";
        this.inputflag = 0;
        this.curr_op = 2;               // priority
        this.arithmetic[arrayindex] = String.valueOf(this.curr_num);
        this.arithmetic[arrayindex+1] = prev_op_string_actual;
        this.arithmetic[arrayindex+2] = String.valueOf(this.new_num);
        // if this pripority is lower than old, execute everything now (execute based on priority)
        // if this priority is higher put previous operation and number inside array
        this.displaynum = this.new_num;
        if (this.displaynum / 100000000 > 1){
            return overflow.format(this.displaynum);
        }
        else{
            return df.format(this.displaynum);
        }
    }
    public String btnequals () {
        if (errorflag == 1) {
            return "Error";
        }
        this.curr_op = 0;               // priority
        // if logrootsquareflag is activated, it does the operation and puts it in new num
        if (this.logrootsquareflag != "a"){
            if (returnLogrootsquare(this.logrootsquareflag) == "Error"){
                return "Error";
            }
            this.logrootsquareflag = "a";
        }
        this.arithmetic[arrayindex] = String.valueOf(this.curr_num);
        this.arithmetic[arrayindex+1] = this.prev_op_string_actual;
        this.arithmetic[arrayindex+2] = String.valueOf(this.new_num);
        doPreviousOperations(0);
        this.curr_num = 0;
        this.prev_num = 0;
        this.inputflag = 0;
        this.prev_op = 0;
        this.new_num = this.displaynum;
        this.curr_op = 0; //higher cuz start
        this.prev_op_string = "a";
        this.prev_op_string_actual = "a";
        this.arithmetic = new String[8];
        this.arrayindex = 0;
        this.selectflag = 0;
        this.decimalpressflag = 0;
        this.decimalzeros = 0;
        this.arithmetic[arrayindex] = String.valueOf(this.displaynum);
        this.arithmetic[arrayindex+1] = "+";
        this.arithmetic[arrayindex+2] = String.valueOf(this.displaynum);
        if (this.displaynum / 100000000 > 1){
            return overflow.format(this.displaynum);
        }
        else{
            return df.format(this.displaynum);
        }
    }
    // clear all
    public String btnclear () {
        this.curr_num = 0;
        this.prev_num = 0;
        this.inputflag = 0;
        this.displaynum = 0;
        this.prev_op = 0;
        this.new_num = 0;
        this.curr_op = 0; //higher cuz start
        this.errorflag = 0;
        this.prev_op_string = "a";
        this.prev_op_string_actual = "a";
        this.arithmetic = new String[8];
        this.arrayindex = 0;
        this.clearflag = 1;
        this.selectflag = 0;
        this.decimalpressflag = 0;
        this.decimalzeros = 0;
        this.logrootsquareflag = "a";
        this.arithmetic[arrayindex] = "0";
        this.arithmetic[arrayindex+1] = "+";
        this.arithmetic[arrayindex+2] = "0";
        return "0";
    }
    // ln, x^2, square root, if number is cleared or during operation press, then it will activate after
    // this is when there is an input on the board
    public String returnLogrootsquare(String n){
        this.inputflag = 0;
        if (n == "ln"){
            // IF 0 OR LESS IT RETURNS ERROR
            if (this.new_num > 0){
                this.new_num = Math.log(this.new_num);
            }
            else{
                return "Error";
            }
        }
        if (n == "^2"){
            this.new_num = Math.pow(this.new_num,2);
        }
        if (n == "rt"){
            // IF NEGATIVE IT RETURNS ERROR
            if (this.new_num >= 0){
                this.new_num = Math.sqrt(this.new_num);
            }
            else{
                return "Error";
            }
        }
        if (this.new_num / 100000000 > 1){
            return overflow.format(this.new_num);
        }
        else{
            return df.format(this.new_num);
        }

    }
    // this is when it will activate after
    public void setLogrootsquare(String n){
        this.logrootsquareflag = n;
    }
    // decimal, percent, sign
    // returns selectflag
    public int getSelectflag (){
        return this.selectflag;
    }
    public int getClearflag (){
        return this.clearflag;
    }
    public String btndecimal () {
        String fullstring;
        if (this.new_num % 1 == 0 && decimalpressflag == 2){
            fullstring = ".";
        }
        else{
            fullstring = "";
        }
        // if currently operation, dont do anything, also check if decimal press flag is already on, used, check decimal in thing already
        if (this.selectflag == 1 || this.decimalpressflag == 2 || this.new_num % 1 != 0){
            // put in the 0s from before too in case some dude presses decimal again
            for (int i = 0; i < this.decimalzeros; i++){
                fullstring = fullstring + "0";
            }
            return df.format(this.new_num) + fullstring;
        }
        else {
            this.decimalpressflag = 1;
            return df.format(this.new_num) + ".";
        }
    }
    public String btnpercent () {
        this.inputflag = 0;
        this.new_num = this.new_num / 100;
        return df.format(this.new_num);
    }
    public String btnsign () {
        this.new_num = this.new_num * -1;
        return df.format(this.new_num);
    }

    // will do previous operations based on prioirty blah blah, if after nothing, this.displaynum = this.newnum
    public void doPreviousOperations(int priority){
        String number1;
        String number2;
        String operation;
        // if same as previous operation, just do regular and put whatever it is inside the array of previous
        if (this.prev_op == this.curr_op) {
            if (this.prev_op_string_actual == "+") {
                this.displaynum = this.curr_num + this.new_num;
            }
            else if (this.prev_op_string_actual == "-") {
                this.displaynum = this.curr_num - this.new_num;
            }
            else if (this.prev_op_string_actual == "*") {
                this.displaynum = this.curr_num * this.new_num;
            }
            else if (this.prev_op_string_actual == "/") {
                this.displaynum = this.curr_num / this.new_num;
            }
            else if (this.prev_op_string_actual == "^") {
                this.displaynum = Math.pow(this.curr_num,this.new_num);
            }
            else {
                this.displaynum = this.new_num;
            }
            return;
        }
        int arraynullflag = 0;
        // do array thingy
        // do every operation inside the array, no power because power is not stored, highest priority
        // if array doesnt contain all null, set flag
        for (int i = 0; i < this.arithmetic.length; i++){
            if (this.arithmetic[i] != null){
                arraynullflag = 1;
            }
        }
        // only calculate up to prioirty
        int i;
        if (arraynullflag == 1) {
            for (i = this.arithmetic.length - 1; i > 0; i--) {
                // find the first number, then get the one behind it and do the operation
                if (this.arithmetic[i] != null && this.arithmetic[i] != "+" && this.arithmetic[i] != "-" && this.arithmetic[i] != "*" && this.arithmetic[i] != "/" && this.arithmetic[i] != "^") {
                    number2 = this.arithmetic[i];
                    operation = this.arithmetic[i - 1];
                    number1 = this.arithmetic[i - 2];
                    if (operation == "+") {
                        if (priority > 0){
                            break;
                        }
                        this.arithmetic[i - 2] = String.valueOf(Double.parseDouble(number1) + Double.parseDouble(number2));
                    } else if (operation == "-") {
                        if (priority > 0){
                            break;
                        }
                        this.arithmetic[i - 2] = String.valueOf(Double.parseDouble(number1) - Double.parseDouble(number2));
                    } else if (operation == "*") {
                        if (priority > 1){
                            break;
                        }
                        this.arithmetic[i - 2] = String.valueOf(Double.parseDouble(number1) * Double.parseDouble(number2));
                    } else if (operation == "/") {
                        if (priority > 1){
                            break;
                        }
                        this.arithmetic[i - 2] = String.valueOf(Double.parseDouble(number1) / Double.parseDouble(number2));
                    } else if (operation == "^") {
                        if (priority > 2){
                            break;
                        }
                        this.arithmetic[i - 2] = String.valueOf(Math.pow(Double.parseDouble(number1), Double.parseDouble(number2)));
                    }
                    else if (operation == "a"){
                        this.arithmetic[i-2] = number2;
                    }
                    this.arithmetic[i] = null;
                    this.arithmetic[i - 1] = null;
                    i--;
                }
            }
            this.arrayindex = i;
            this.displaynum = Double.parseDouble(this.arithmetic[i]);
            return;
        }

    }
}
