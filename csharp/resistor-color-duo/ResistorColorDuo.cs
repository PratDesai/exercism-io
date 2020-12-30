using System.Collections.Generic;
using System.Linq;

public static class ResistorColorDuo
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

  private static List<int> m_multiplers = new List<int> { 10, 1 };

  public static int Value(string[] colors)
  {
    return colors
            .Select(x => m_colors.IndexOf(x))
            .Select((x, i) => m_multiplers[i] * x)
            .Sum();
  }
}