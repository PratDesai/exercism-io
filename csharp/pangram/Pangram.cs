using System.Linq;
using System.Text.RegularExpressions;

public static class Pangram
{
  public static bool IsPangram(string input)
  {
    var pattern = new Regex("[^a-z]");
    return pattern.Replace(input.ToLower(), "").Distinct().Count() == 26;
  }
}
