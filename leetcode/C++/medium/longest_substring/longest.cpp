#include <iostream>
#include <map>
#include <iterator>
using namespace std;


class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        int start = 0;
        int end = 0;
        int len = s.length();
        map <char, int> amap;
        int maxLen = 0;
        int currlen = 0;

        while (end < len){
            char curr = s.at(end);
            // found in prev checked
            if (amap.count(curr)){
                int prevStart = start;
                start = amap[curr] + 1;

                for (int i = prevStart; i < start; ++i) {
                    amap.erase(s.at(i));
                }
            }else{
                amap.insert({curr, end});
                end++;
                currlen = end - start;
                if ((currlen) > maxLen){
                    maxLen = currlen;
                }
            }
        }
        return maxLen;
    }
};

int main(int argc, char **argv){
    Solution s;
    string str = "aaaaaaabcd";
    int result = s.lengthOfLongestSubstring(str);
    printf("Longest substring of \"%s\" is: %d\n", str.c_str(), result);
}