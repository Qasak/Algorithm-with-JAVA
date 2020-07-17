## 双向链表+哈希表

Python

```python
import collections
class LRUCache(collections.OrderedDict):
    def __init__(self, capacity:int):
        super().__init__()
        self.capacity=capacity
    def get(self, key:int) -> int:
        if key not in self:
            return -1
        else:
            self.move_to_end(key)
            return self[key]
    def set(self, key:int, val:int):
        if key in self:
            self.move_to_end(key)
        self[key]=val
        if len(self) > self.capacity:
            self.popitem(last=False)
```

