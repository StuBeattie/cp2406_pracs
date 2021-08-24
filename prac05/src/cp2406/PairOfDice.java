package cp2406;

   /* In all versions of the PairOfDice class in Section 5.2,
   the instance variables die1 and die2 are declared to be public.
   They really should be private, so that they would be protected from being changed from outside the class.
   Write another version of the PairOfDice class in which the instance variables die1 and die2 are private.
   Your class will need "getter" methods that can be used to find out the values of die1 and die2.
   (The idea is to protect their values from being changed from outside the class,
   but still to allow the values to be read.) Include other improvements in the class,
   including at least a toString() method. Test your class with a short program
   that counts how many times a pair of dice is rolled, before the total of the two dice is equal to two.
   */
   public class PairOfDice {
         private int die1;
         private int die2 = 4;   // Number showing on the second die.
         private int sum;

         @Override
         public String toString() {
             return "toString: dice1 = " + die1 + ", die2 = " + die2;
         }

         public void roll() {
             // Roll the dice by setting each of the dice to be
             // a random number between 1 and 6.
             die1 = (int) (Math.random() * 6) + 1;
             die2 = (int) (Math.random() * 6) + 1;
             sum = die1 + die2;
             System.out.println("dice1 = " + die1 + ", die2 = " + die2);
         }

       public  int getDie1() {
           return die1;
       }

       public  int getDie2() {
           return die2;
       }

       public int getSum() {
           return sum;
       }

}
