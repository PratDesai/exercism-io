using System.Collections.Generic;
using System.Linq;

public static class Isogram
{
  public static bool IsIsogram(string word)
  {
    var normalized = Normalize(word);
    return normalized.Count() == normalized.Distinct().Count();
  }

  private static string Normalize(string val)
  {
    return val.Replace("-", "").Replace(" ", "").ToLower();
  }
}