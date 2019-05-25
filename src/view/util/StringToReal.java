package view.util;

public class StringToReal
{
    public static float stringToFloat(String value)
    {
        value = value.replace(",", ".");

        return Float.parseFloat(value);
    }
}
