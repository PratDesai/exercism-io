using System.Collections.Generic;

public static class ResistorColor
{
    private static List<string> m_colors = new List<string> {
        "black",
        "brown",
        "red",
        "orange",
        "yellow",
        "green",
        "blue",
        "violet",
        "grey",
        "white",
    };

    public static int ColorCode(string color) => m_colors.IndexOf(color);

    public static string[] Colors() => m_colors.ToArray();
}