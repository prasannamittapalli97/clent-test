package com.vending.steps;


public class VendingExample
{
    // add coins
    public int drop(String coins, int total)
    {

        if(coins.equals("PENNY")){
            total = total + Coin.PENNY.getDenom();
        }else if(coins.equals("NICKEL")){
            total = total + Coin.NICKEL.getDenom();
        }else if(coins.equals("DIME")){
            total = total + Coin.DIME.getDenom();
        }else if(coins.equals("QUARTER")){
            total = total + Coin.QUARTER.getDenom();
        }else{
            System.out.println("Wrong Input Coin");
        }

        return total;
    }

    //Select Products
    public String selectProduct(String sample, int total)
    {
        String productMessage = "";

        if(sample.equals("COKE")){
            if(total>=Item.COKE.getPrice()){
                total = total - Item.COKE.getPrice();
                productMessage = "You have selected "+Item.COKE.getName();
            }else{
                productMessage = "Insert more coins";
            }

        }else if(sample.equals("PEPSI")){
            if(total>=Item.PEPSI.getPrice()){
                total = total - Item.PEPSI.getPrice();
                productMessage = "You have selected "+Item.PEPSI.getName();
            }else{
                productMessage = "Insert more coins";
            }
        }else if(sample.equals("SODA")){
            if(total>=Item.SODA.getPrice()){
                total = total - Item.SODA.getPrice();
                productMessage = "You have selected "+Item.SODA.getName();
            }else{
                productMessage = "Insert more coins";
            }
        }else if(sample.equals("RETURN")){
            productMessage = "Your balance is "+total+" and is returned.";
        }else{
            productMessage = "Wrong choice: Your balance is "+total;
        }

        return productMessage;
    }

    public String selectProductWithBalance(String sample, int total)
    {
        String productMessage = "";

        if(sample.equals("COKE")){
            if(total>=Item.COKE.getPrice()){
                total = total - Item.COKE.getPrice();
                productMessage = "You have selected "+Item.COKE.getName()+" and balance is "+total;
            }else{
                productMessage = "Insert more coins";
            }

        }else if(sample.equals("PEPSI")){
            if(total>=Item.PEPSI.getPrice()){
                total = total - Item.PEPSI.getPrice();
                productMessage = "You have selected "+Item.PEPSI.getName()+" and balance is "+total;
            }else{
                productMessage = "Insert more coins";
            }
        }else if(sample.equals("SODA")){
            if(total>=Item.SODA.getPrice()){
                total = total - Item.SODA.getPrice();
                productMessage = "You have selected "+Item.SODA.getName()+" and balance is "+total;
            }else{
                productMessage = "Insert more coins";
            }
        }else if(sample.equals("RETURN")){
            productMessage = "Your balance is "+total+"";
        }else{
            productMessage = "Wrong choice: Your balance is "+total;
        }

        return productMessage;
    }

    //select items
    public int choose(String sample, int total)
    {
        if(sample.equals("COKE")){
            System.out.println("You have selected "+Item.COKE.getName());
            if(total>=Item.COKE.getPrice()){
                total = total - Item.COKE.getPrice();
                System.out.println("Thank you for your purchase!! ");
                System.out.println("Your balance is "+total);
            }else{
                System.out.println("Insert more coins ");
                return 2;
            }

        }else if(sample.equals("PEPSI")){
            System.out.println("You have selected "+Item.PEPSI.getName());
            if(total>=Item.PEPSI.getPrice()){
                total = total - Item.PEPSI.getPrice();
                System.out.println("Thank you for your purchase!! ");
                System.out.println("Your balance is "+total);
            }else{
                System.out.println("Insert more coins ");
                return 2;
            }
        }else if(sample.equals("SODA")){
            System.out.println("You have selected "+Item.SODA.getName());
            if(total>=Item.SODA.getPrice()){
                total = total - Item.SODA.getPrice();
                System.out.println("Thank you for your purchase!! ");
                System.out.println("Your balance is "+total);
            }else{
                System.out.println("Insert more coins ");
                return 2;
            }
        }else if(sample.equals("RETURN")){
            System.out.println("Your balance is "+total+" and is returned.");
            return 1;
        }else if(sample.equals("RESET")){
            return -1;
        }else{
            System.out.println("Wrong choice: Your balance is "+total);
            return 1;
        }

        return total;
    }
}
