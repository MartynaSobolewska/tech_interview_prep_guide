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
                int pair = target - i;
                if (map.count(pair)){
                    printf("[%d, %d]\n", i, pair);
                    vector<int> result {i, pair};
                    return result;
                }
            }
            vector<int> vect {};
            return vect;
        }
};

int main(int argc, char **argv){
    Solution s;
    vector<int> vect { 10, 20, 30, 2, 1, 8, 4 };
    s.twoSum(vect, 24);
}