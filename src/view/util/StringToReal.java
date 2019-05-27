package view.util;

public class StringToReal
{
    public static float stringToFloat(String value)
    {
        value = value.replace(",", ".");

        return Float.parseFloat(value);
    }

    public static String floatToReal(float value)
    {
        String newValue = String.valueOf(value);
        newValue = newValue.replace(".", ",");
        return "R$ "+newValue;
    }
}
