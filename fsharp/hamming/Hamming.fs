module Hamming

let allNuleotides s = String.forall "CAGT".Contains s

let distance (s1: string) (s2: string) : int option =
    match (s1.Length = s2.Length, allNuleotides (s1), allNuleotides (s2)) with
    | (false, _, _) -> None
    | (_, false, _) -> None
    | (_, _, false) -> None
    | _ ->
        Seq.map2 (<>) s1 s2
        |> (Seq.filter id >> Seq.length >> Some)
