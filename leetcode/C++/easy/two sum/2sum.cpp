#include <map>
#include <vector>
using namespace std;

class Solution {
    public:
        vector<int> twoSum(vector<int>& nums, int target) {
            map<int, int> map;
            int count = 0;
            for (int i : nums){
                printf("i = %d\n", i);
                map.insert({i, count});
                printf("[%d, %d]\n", i, count);
                int pair = target - i;
                if (map.count(pair) && map[pair] != count){
                    printf("OUT: [%d, %d]\n", map[pair], count);
                    vector<int> result {map[pair], count};
                    return result;
                }
                count++;
            }
            vector<int> vect {};
            return vect;
        }
};

int main(int argc, char **argv){
    Solution s;
    vector<int> vect { 3, 2, 4 };
    s.twoSum(vect, 6);
}