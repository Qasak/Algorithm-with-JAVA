#include <iostream>
#include <vector>

using namespace std;

vector<int> getNext(string p) {
    int n = p.size(), k = -1, j = 0;
    vector<int> next(n, -1);
    while (j < n - 1) {
        if (k == -1 || p[j] == p[k]) {
            ++k; ++j;
            next[j] = (p[j] != p[k]) ? k : next[k];
        } else {
            k = next[k];
        }
    }
    return next;
}

bool kmp(string s, string p) {
    int m = s.size(), n = p.size(), i = 0, j = 0;
    vector<int> next = getNext(p);
    while (i < m && j < n) {
        if (j == - 1 || s[i] == p[j]) {
            ++i; ++j;
        } else {
            j = next[j];
        }
    }
    return (j == n);
}

int main() {
    cout << kmp("eidbaooo", "ba") << endl; // Output: 15
}