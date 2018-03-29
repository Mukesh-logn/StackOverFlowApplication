package mindtree.com.stackoverflow.restclient.responsemodel;

/**
 * Created by M1030452 on 3/28/2018.
 */

public class BadgeCount
{
    private String bronze;

    private String silver;

    private String gold;

    public String getBronze ()
    {
        return bronze;
    }

    public void setBronze (String bronze)
    {
        this.bronze = bronze;
    }

    public String getSilver ()
    {
        return silver;
    }

    public void setSilver (String silver)
    {
        this.silver = silver;
    }

    public String getGold ()
    {
        return gold;
    }

    public void setGold (String gold)
    {
        this.gold = gold;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [bronze = "+bronze+", silver = "+silver+", gold = "+gold+"]";
    }
}
