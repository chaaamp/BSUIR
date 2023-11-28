#include<iostream>
#include<vector>

using namespace std;

vector<int> vec;

int main() {
    cout << "Enter amout of elements you want to add:";//1
    int n = 0;//1
    cin >> n;//1
    
    if (n <= 0 || n >= 100) {//1
        cout << "N is uncorrect";
        return 0;
    }

    int* arr = new int[n];//1
    for (int i = 0; i < n; i++) {//n
        cout << "Enter an element:";//n
        cin >> arr[i];//n
    }
    for (int i = 0; i < n - 2; i++) {//n-2 
        if (arr[i + 1]<arr[i] && arr[i + 2]>arr[i + 1]) {//n-2
            vec.push_back(arr[i + 1]);//n-2
        }
    }

    if (vec.size() == 0) {//1
        cout << "There is no local minimums";//1
    }
    else {
        int min = vec[0];//1
        for (int i = 0; i < vec.size() - 1; i++) {//m
            if (vec[i + 1] < vec[i]) {//m
                min = vec[i + 1];//m
            }
        }
        cout << min;//1
    }
    return 0;//1
}
//difficulty 6n+4+3m , где m-количество локальных минимумов, n - кол-во элеменотов массива
//worst_case n = 99 : 6 * 99 + 4 + 3 * 40 = 718
// best_case n = 1 : 6 * 1 + 4 + 3 * 0 = 10
//memory 104
//(константы отбрасываем)time in worst case O(N) :  3 + 3m 