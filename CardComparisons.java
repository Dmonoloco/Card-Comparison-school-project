public class CardComparisons
{
    public static void main(String[] args)
    {
        // Create an a 4 x 5 2D array of Cards however you want (individually, use loop, etc)
        Card[][] deck = new Card[4][5];
        //String suit for name of suit
        String suit = "";
        //row major traversel for 2d array deck
        for(int i = 0; i < deck.length; i++)
        {
            //if i = 0, then suit will be intallized as Diamonds, if i = 1, then suit will be intallized as Spades
            //if i = 2, then suit will be intallized as Clovers, if i = 3, then suit will be intallized as Hearts
            if(i == 0)
                suit = "Diamonds";
            else if (i == 1)
                suit = "Spades";
            else if(i == 2)
                suit = "Clovers";
            else if (i == 3)
                suit = "Hearts";
            for(int j = 0; j < deck[0].length;j++)
            {
                //creats a new card object for each row using the suit, set value depending on current j value 
                //and sets value corresponding to rank 
                if(j == 0)
                    deck[i][j] = new Card(suit,"8",8); 
                else if(j == 1)
                    deck[i][j] = new Card(suit,"ace",14);
                else if(j == 2)
                    deck[i][j] = new Card(suit,"jack",11);
                else if(j == 3)
                    deck[i][j] = new Card(suit,"5",5);
                else if(j == 4)
                    deck[i][j] = new Card(suit,"9",9);
            }
        }
        
        //prints out the 2d array
        for(int i = 0; i < deck.length; i++)
        {
            for(int j = 0; j < deck[0].length;j++)
            {
                System.out.print(deck[i][j] + ", ");
            }
            System.out.println();
        }        
        
        // Print out your entire Card array in an easy to read matrix
        
        // Call each of the methods below with accompanying text
        // make sure to change your array to throughly test your methods
        // Double check that your methods work correctly!!
        
        System.out.println("\nfindCard test for rank 5: " + findCard(deck,"5"));
        
        System.out.println("\nfindCard test for rank queen: " + findCard(deck,"Queen"));
        
        System.out.println("\npercentSuit test for spades: " + percentSuit(deck, "Spades"));
        
        System.out.println("\nsameSuitColumn test for column 2: " + sameSuitColumn(deck,2));
        
        System.out.println("\nmaxCard test: card with the max value is " + maxCard(deck) );
        
        System.out.println("\nmaxSumRow test: row with highest sum of values is at index " + maxSumRow(deck) );
        
        System.out.println("\nmaxSumColumn test: column with highest sum of values is at index " + maxSumColumn(deck) );
        
    }
    
    // #1 finds card with the given rank
    // returns true if the card is in the 2D array
    // returns false if there is no card with the given rank
    public static boolean findCard(Card[][] cards, String rank)
    {
        //checks each card object in the 2d array
        for(int i = 0; i < cards.length; i ++)
        {
            for(int j = 0; j < cards[0].length; j++)
            {
                //if current card rank equals the search rank, then method returns true 
                if( cards[i][j].getRank().equals(rank) )
                    return true;
            }
            
        }
        
        //returns false if there is no card with given rank
        return false;
    }
    
    // #2 returns the ratio of cards with the given suit
    // ratio is count/totalItems
    public static double percentSuit(Card[][] cards, String suit)
    {
        //stores total number of objects in 2d array
        int total = 0; 
        //stores count of suit
        int countSuit = 0;
        //traverses the 2d array
        for(int i = 0; i < cards.length; i++)
        {
            for(int j = 0; j < cards[0].length;j++)
            {
                //if current card object suit equals the searched suit,
                //coundSuit will increase by 1
                if(cards[i][j].getSuit().equals(suit))
                    countSuit++;
                //total will increase by 1 for each object in array
                total++;
            }
        }
        
        //returns the ratio after converting countSuit to double
        return (double)countSuit/total;
    }
    
    // #3 parameters are 2D array and column number
    // Return true if all cards in the given column are the same suit, false otherwise
    public static boolean sameSuitColumn(Card[][] cards, int col)
    {
        //stores the first suit in column
        String suit = cards[0][col].getSuit();
        //traverses the column of 2d array
        for(int row = 0; row < cards.length;row++)
        {
            //if current card object does not equal suit, then false is returned 
            if(!cards[row][col].getSuit().equals(suit))
                return false;
        }
        //if for loop passes, then method will return true 
        return true;
    }
    
    // #4 Returns the max value card in the 2D Array
    // Return first if there are multiple with same value
    public static Card maxCard(Card[][] cards)
    {
        //stores the max card 
        Card max = cards[0][0];
        
        //traverses through 2d array
        for(int i = 0; i < cards.length;i++)
        {
            for(int j = 0; j < cards[0].length;j++)
            {
                //if current card objects value is greater than 
                //current card object than max is set to current card object
                if( cards[i][j].getValue() > max.getValue() )
                    max = cards[i][j];
            }
        }
        
        //returns the card with the highest value
        return max;
    }
    
    // #5 returns the index of the row with the highest sum of values
    // Return first if there are multiple row with same sum
	public static int maxSumRow (Card[][] arr) 
	{
	    //stores the row with highest sum of values
        int highestSum = Integer.MIN_VALUE;
        //stores the current sum of row
        int sum = 0;
        //stores the index of the row with highest sum of values 
        int index = 0;
         
        //traveres 2d array by row major 
        for(int i = 0; i < arr.length; i++)
        {
            for(int j = 0; j < arr[0].length;j++)
            {
                //sum adds up each card value in current row 
                sum += arr[i][j].getValue();
            }
            //if current sum value is greater than highestSum
            //than highestSum will be initalized to sum
            //and will store current row index 
            if(sum > highestSum)
            {
                highestSum = sum;
                index = i;
            } 
            //sum is reverted back to zero 
            sum = 0;
        }
        
        //returns index of row with highest sum of values 
        return index;
	}
	
	// #6 returns the index of the column with the highest sum of values
	public static int maxSumColumn(Card[][] arr)
	{
	    //stores the column with highest sum of values
	    int highestSum = Integer.MIN_VALUE;
	    //stores current column sum of values
        int sum = 0;
        //stores index of column with highest sum of values
        int index = 0;
        
        //traveres 2d array by column major  
        for(int j = 0; j < arr[0].length;j++)
        {
            
            for(int i = 0; i < arr.length; i++)
            {
                //sum adds up each card value in current column
                sum += arr[i][j].getValue();
            }
            //if current column sum is greater than highest sum,
            //then highestSum will store current sum
            //and store the current i value as the index
            if(sum > highestSum)
            {
                highestSum = sum;
                index = j;
            }
            //sum is set to zero for each outter loop iteration
            sum = 0;
        }
    
        //returns index of column with highest sum of values 
        return index;
	}
}
