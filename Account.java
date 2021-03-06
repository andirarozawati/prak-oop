import java.math.BigDecimal;
import java.lang.Math;
import java.math.MathContext;
import java.io.*;

/**
 * kelas account berisikan deskripsi atau informasi akun customer
 * 
 * @author andirarozawati 
 * @version 27/02/2016
 */
public abstract class Account implements Serializable
{
   /* private char acctType;*/
    protected double balance;
    protected String id;
    protected static MathContext mc = new MathContext(5);
    private Customer account_owner;
   
    /*
   /**
     * constructur kelass account
     */
    /*
    public Account(double amount) {
        balance = amount;
    }*/
   
    /*
    /**
     * method pada costractor account
     * @param type tipe akun customer
     * @param amount nilai balance customer 
     */
    /*
    public Account (char type, double amount)
    {
      /*acctType = type;*/
      /*balance = amount;*/
    
   
    /**
     * method untuk deposit customer
     * @param amount nilai balance akun customer 
     */
    public boolean deposit(double amount)
    {
        if (amount < 0)
        { //cek deposit customer apakah kurang dari 0
            return false;
        }
        else
        { //deposit customer lebih dari 0
            balance = balance + amount;// menambhakan uang deposit
            return true;
        }
    }
    
    
    
    
    public String toString(){
        return id;        
    }
    
   /**
     * Method to get balance value
     * 
     * @return balance in double
     */
    public double getBalance() {
        return balance;
    }
    
    /**
     * method untuk mendapatkan ID customer
     * @return no id customer
     */
    public String getId()
    {
        return id;
    }
    
    /**
     * method untuk assign nilai balance customer
     * @param amount nilai deposit customer
     */
    public void setBalance (double amount)
    {
        this.balance = amount;
    }
    
    /*
    /**
     * method untuk assign ID customer
     * @param accId ID dari akun 
     */
    /*
    public void setID (String acctId)
    {
        this.id = acctId;
    }
    */
   /*
   
    /**
     * method untuk assign tipe akun customer
     * @param type tipe akun
     */
    /*
    public void setAcctType(char type)
    {
        this.acctType = type;
    }
    */
    
    /**
     * method untuk customer mengambil uang
     */
    public abstract void withdraw (double amount) throws AmountOverDrawnException ;
    
      public static double nilai(double saldo, double rate, double compound, double period)
    {
         BigDecimal saldoS = new BigDecimal (saldo);
         BigDecimal t = new BigDecimal (rate);
         BigDecimal n = new BigDecimal (compound);
         BigDecimal p = new BigDecimal (period);
         BigDecimal f1Saving = t.divide(n, mc).add(new BigDecimal(1.0));
         BigDecimal f2 = n.multiply(t, mc);
         BigDecimal f3Saving = new BigDecimal (Math.pow(f1Saving.doubleValue(), f2.doubleValue()),mc);
         BigDecimal f4Saving = f3Saving.multiply(saldoS, mc);
         return f4Saving.doubleValue();
    }
    /*
    {
        if (balance - amount < 0)//cek nilai withdraw apakah akan menghasilkan deposit yang negatif
        {
            return false;
        } 
        else 
        {//mengurangi balance saat withdraw
            balance = balance - amount;
            return true;
        }
    }
    */
    
}
    
