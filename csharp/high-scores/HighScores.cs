using System.Collections.Generic;
using System.Linq;

public class HighScores
{
    private List<int> m_scores;
    
    public HighScores(List<int> list)
    {
        m_scores = list;
    }

    public List<int> Scores() => m_scores;

    public int Latest() => m_scores.Last();

    public int PersonalBest() => m_scores.Max();

    public List<int> PersonalTopThree() => 
        m_scores.OrderByDescending(x => x).Take(3).ToList();
}