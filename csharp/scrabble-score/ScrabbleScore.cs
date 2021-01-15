using System.Collections.Generic;
using System.Linq;

public static class ScrabbleScore
{
    private static List<(string Letters, int Score)> m_letterScores = new List<(string, int)> {
        ("AEIOULNRST", 1),
        ("DG", 2),
        ("BCMP", 3),
        ("FHVWY", 4),
        ("K", 5),
        ("JX", 8),
        ("QZ", 10),
    };

    public static int Score(string input)
    {
        return input.ToUpper()
                    .Select(x => m_letterScores.FirstOrDefault(
                        y => y.Letters.Contains($"{x}")))
                    .Select(x => x.Score)
                    .Sum();
    }
}