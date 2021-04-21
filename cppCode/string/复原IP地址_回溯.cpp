/*
1.取一位作为IP地址的一个数：
（1）判断剩余长度是否合法，
（1）合法则继续；
2.取两位作为IP地址的一个数：
（1）判断剩余长度是否合法，
（2）判断取的两位首位是否为0，
（1）（2）均合法则继续；
3.取三位作为IP地址的一个数：
（1）判断剩余长度是否合法，
（2）判断取的三位首位是否为0，
（3）判断该数是否<=255，
（1）（2）（3）均合法则继续；
4.递归结束条件：已取完四个数。将结果添加至结果数组，结束。

 

*/

#define MAX 166     //排列组合简单算的，实际没有这么多，很多情况不合法
void dfs(char* s,char** res,int* returnSize,int step,int index,int len,char* temp){
    if(step==4){    //结束条件：已取完四个数，将结果添加至结果数组
        res[*returnSize] = (char*)malloc(sizeof(char)*(len+4));
        temp[index+step-1] = '\0';      //将最后一个'.'去掉
        strcpy(res[*returnSize],temp);
        (*returnSize)++;
        return;
    }
    //取一位数；剪枝：剩余长度不合法的情况
    if(len-index-1<=(3-step)*3 && len-index-1>=(3-step)){
        temp[index+step] = s[index];
        temp[index+step+1] = '.';
        dfs(s,res,returnSize,step+1,index+1,len,temp);
    }
    //取两位合法数（首位不为0）；剪枝：剩余长度不合法的情况
    if(len-index-2<=(3-step)*3 && len-index-2>=(3-step) && s[index]!='0'){
        temp[index+step] = s[index];
        temp[index+step+1] = s[index+1];
        temp[index+step+2] = '.';
        dfs(s,res,returnSize,step+1,index+2,len,temp);
    }
    //取三位合法数（首位不为0，且<=255）；剪枝：剩余长度不合法的情况
    if(len-index-3<=(3-step)*3 && len-index-3>=(3-step) && s[index]!='0' && (s[index]-'0')*100+(s[index+1]-'0')*10+s[index+2]-'0'<=255){
        temp[index+step] = s[index];
        temp[index+step+1] = s[index+1];
        temp[index+step+2] = s[index+2];
        temp[index+step+3] = '.';
        dfs(s,res,returnSize,step+1,index+3,len,temp);
    }
}
char ** restoreIpAddresses(char * s, int* returnSize){
    *returnSize = 0;
    int len = strlen(s);
    if(len>12 || len<4)return NULL;     //长度不合法直接return

    char** res = (char**)malloc(sizeof(char*)*MAX);
    char* temp =(char*)malloc(sizeof(char)*(len+5));
    dfs(s,res,returnSize,0,0,len,temp);
    return res;
}

 