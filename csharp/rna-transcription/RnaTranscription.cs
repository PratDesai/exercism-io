using System.Collections.Generic;
using System.Linq;

public static class RnaTranscription
{
    private static Dictionary<string, string> m_nucleotideToRna = new Dictionary<string, string>
    {
        {"G", "C"},
        {"C", "G"},
        {"T", "A"},
        {"A", "U"},
    };

    public static string ToRna(string nucleotide)
    {
        return string.Concat(nucleotide.Select(x => m_nucleotideToRna[$"{x}"]));
    }
}