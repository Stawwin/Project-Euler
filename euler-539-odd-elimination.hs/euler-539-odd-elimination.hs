compute :: Integer -> Integer
compute 1 = 1
compute n
  | even n    = (compute (n - 1) + p n) `mod` modVal
  | otherwise = (1 + 2 * m * (m + 1) + 4 * m - 4 * compute m) `mod` modVal
  where
    modVal = 987654321
    m = (n - 1) `div` 2

p :: Integer -> Integer
p 1 = 1
p 2 = 2
p n = 2 * v + 2 - 2 * p v
  where
    v = n `div` 2

main :: IO ()
main = do
  let n = 1000000000000000000
  print $ compute n
