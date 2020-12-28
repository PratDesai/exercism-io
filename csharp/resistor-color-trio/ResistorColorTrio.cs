using System;
using System.Collections.Generic;
using System.Linq;

public static class ResistorColorTrio
{
    private static readonly Dictionary<string, int> m_colors = new Dictionary<string, int>
    {
        // to help formatter
        { "black", 0 },
        { "brown", 1 },
        { "red", 2 },
        { "orange", 3 },
        { "yellow", 4 },
        { "green", 5 },
        { "blue", 6 },
        { "violet", 7 },
        { "grey", 8 },
        { "white", 9 }
    };

    private static readonly Dictionary<int, string> m_metricPrefixes = new Dictionary<int, string>
    {
        // to help formatter
        { 1000, "kilo" },
        { 1000000, "mega" },
        { 1000000000, "giga" }
    };

    public static string Label (string[] colors)
    {
        var resistance = Resistance (colors);
        var (adjustedResistance, prefix) = MetricPrefixAdjust (resistance);
        return $"{adjustedResistance} {prefix}ohms";
    }

    private static (int adjustedNumber, string prefix) MetricPrefixAdjust (int number)
    {
        var biggestPrefix = m_metricPrefixes
            .OrderByDescending (s => s.Key)
            .FirstOrDefault (x =>
            {
                return number > x.Key && number % x.Key == 0;
            });
        return !biggestPrefix.Equals (default (KeyValuePair<int, string>)) ?
            (number / biggestPrefix.Key, biggestPrefix.Value) :
            (number, "");
    }

    private static int Resistance (string[] colors)
    {
        var nums = colors.Select (x => m_colors[x]).ToList ();
        return Convert.ToInt32 (((nums[0] * 10) + nums[1]) * (Math.Pow (10, nums[2])));
    }
}