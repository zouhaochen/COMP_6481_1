package Tutorial4;

import java.io.Serializable;

public class Employee implements Serializable {
    private String name = "", position = "";
    private int ID = 0;
    private Date hiredDate;

    public Employee(String name, String position, int ID, Date hiredDate) {
        this.name = name;
        this.position = position;
        this.ID = ID;
        this.hiredDate = hiredDate;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void getPosition()
    {
        this.position = position;
    }

    public int getID()
    {
        return ID;
    }

    public void setID(int ID)
    {
        this.ID = ID;
    }

    public String getHiredDate()
    {
        String str = this.hiredDate.toString();
        return str;
    }

    public void setHiredDate(Date hiredDate)
    {
        this.hiredDate = hiredDate;
    }
}
