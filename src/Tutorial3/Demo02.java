package Tutorial3;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

public class Demo02
{
}

class BadIO
{
    public static void cat(File name)
    {
        BadIO obj_IO = new BadIO();

        try
        {
            obj_IO.databaseBlowUp();
            obj_IO.fileBlowUp();
        }
        catch (SQLException | IOException e)
        {
            e.printStackTrace();
        }
    }

    public void databaseBlowUp() throws SQLException
    {
        throw new SQLException();
    }

    public void fileBlowUp() throws IOException
    {
        throw new IOException();
    }
}
