# Counter 不关心key,它是乱序的
class Solution:
    def topKFrequent(self, words: List[str], k: int) -> List[str]:
        counter=collections.Counter(words)
        most_common = [i[0] for i in sorted(counter.items(), key=lambda pair: (-pair[1], pair[0]))]
        return most_common[:k]
        
class Solution(object):
    def topKFrequent(self, words, k):
        count = collections.Counter(words)
        candidates = count.keys()
        candidates.sort(key = lambda w: (-count[w], w))
        return candidates[:k]

