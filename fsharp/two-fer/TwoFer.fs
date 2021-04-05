module TwoFer

let twoFer (input: string option): string =
    let response x = $"One for {x}, one for me."
    match input with
    | Some x -> response x 
    | None -> response "you"