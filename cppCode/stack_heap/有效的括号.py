class Solution:
    def isValid(self, s: str) -> bool:
        stack=[]
        for c in s:
            if c == '(' or c=='[' or c=='{':
                stack.append(c)

            if c == ')':
                if not stack:
                    return False
                if stack.pop(-1) != '(':
                    return False
            if c == ']':
                if not stack:
                    return False
                if stack.pop(-1) != '[':
                    return False
            if c == '}':
                if not stack:
                    return False
                if stack.pop(-1) != '{':
                    return False
        if stack:
            return False
        return True