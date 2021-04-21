class Solution {
public:
/**
* @param arrays: k sorted integer arrays
* @return: a sorted array
*/
vector mergekSortedArrays(vector<vector> &arrays) {

    std::vector<int> result;

    if(arrays.size() == 0){ return result; }
    
    int start_ind {0};
    int end_ind { static_cast<int>(arrays.size()) - 1 };
    
    return helper_inser(arrays,start_ind,end_ind);
    
}

std::vector<int> helper_inser(vector<vector<int>> arrays, 
                              int start_ind,
                              int end_ind
){
    
    if(start_ind == end_ind){ return arrays[start_ind]; }
    else if(start_ind + 1 == end_ind){ return merge2SortedArrays(arrays[start_ind],arrays[end_ind]); }
    
    int mid { start_ind + (end_ind - start_ind)/2 };
    std::vector<int> Left { helper_inser(arrays,start_ind,mid) };
    std::vector<int> Right { helper_inser(arrays,mid + 1,end_ind) };

    std::vector<int> result { merge2SortedArrays(Left,Right) };
    
    return result;
    
}

std::vector<int> merge2SortedArrays( std::vector<int> vec_1, std::vector<int> vec_2){
    
    std::vector<int> result;
    if( vec_1.size() == 0 && vec_2.size() == 0 ){ return result; }
    if( vec_1.size() == 0 ){ return vec_2; }
    if( vec_2.size() == 0 ){ return vec_1; }
    
    int index_1 {0};
    int index_2 {0};
    
    while(index_1 < vec_1.size() && index_2 < vec_2.size()){
        
        if(vec_1[index_1] < vec_2[index_2]){
            
            result.push_back(vec_1[index_1]);
            index_1 ++;
            
        }
        else if(vec_1[index_1] >= vec_2[index_2]){
            
            result.push_back(vec_2[index_2]);
            index_2 ++;
            
        }
        
    }
    
    if(index_1 == vec_1.size()){ 

        result.insert (result.begin() + result.size(),vec_2.begin() + index_2,vec_2.end());
        
    }
    else if(index_2 == vec_2.size()){
        
        result.insert (result.begin() + result.size(),vec_1.begin() + index_1,vec_1.end());
        
    }
    
    return result;
    
}
};

