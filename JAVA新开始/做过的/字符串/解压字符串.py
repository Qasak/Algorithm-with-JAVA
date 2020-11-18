# HG[3|B[2|CA]]F

def parse(zipped):
    zipped='['+zipped+']'
    zipped_list=zipped.replace('[', ' [ ').replace(']', ' ] ').replace('|', ' ').split();
    return zipped_list


def read_from_tokens(tokens):
    token=tokens.pop(0)
    if token=='[':
        L=[]
        while tokens[0] != ']':
            L.append(read_from_tokens(tokens))
        tokens.pop(0)
        return L
    else:
        return token
        

ans=""
def unzip(token_list, ans=""):
    if len(token_list)==0:
        return ""
    if len(token_list)==1 and isinstance(token_list, str):
        return token_list
    token=token_list.pop(0)
    
    if isinstance(token, str) and '0'<=token[0] and token[0]<='9':
        ans+=int(token)*unzip(token_list, "")
        return ans
    elif isinstance(token, str):
        ans+=token+unzip(token_list, "")
        return ans
    else:
        ans+=unzip(token, "")+unzip(token_list)
        return ans

    