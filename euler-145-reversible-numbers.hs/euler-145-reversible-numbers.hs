-- Check if a number has only odd digits
hasOnlyOddDigits :: Integer -> Bool
hasOnlyOddDigits = all odd . map (read . return) . show

-- Check if a number is reversible
isReversible :: Integer -> Bool
isReversible n = n `mod` 10 /= 0 && hasOnlyOddDigits (n + reverseDigits n)

-- Reverse the digits of a number
reverseDigits :: Integer -> Integer
reverseDigits = read . reverse . show

-- Count reversible numbers below a given limit
countReversibleNumbers :: Integer -> Int
countReversibleNumbers limit = length [n | n <- [1..limit-1], isReversible n]

main :: IO ()
main = do
  let limit = 1000
      count = countReversibleNumbers limit

  putStrLn $ "The number of reversible numbers below " ++ show limit ++ " is: " ++ show count
