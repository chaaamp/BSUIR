#include <iostream>
using namespace std;

int main() {
    int i, n, k, l[2];
    double* a, result = 1.0;

    cout << "Vvedite razmer massiva: ";
    cin >> n; 
    a = new double[n];
    for (i = 0; i < n; i++) {
        cout << "Vvedite " << i + 1 << " element massiva: ";
        cin >> a[i];
        cout << endl;
    }
    cout << endl;
    for (i = 0; i < n; i++) {
        switch (i)
        {
        case 1:cout << a[i]; break;
        case 2:cout << a[i] * a[i]; break;
        case 3:cout << a[i - 1]; break;
        default: cout << a[i - 2];
        }

    }
    cout << endl;
    k = 0;
    for (i = n - 1; i >= 0; i--)
    {
        if (a[i] > 0 && k < 2)
        {
            l[k] = i;
            k++;
        }
    }
    if (k == 0)
    {
        cout << "Polozhitelnih elemntov net"; return 1;
    }
    if (l[0] <= l[1])
        for (i = l[0] + 1; i < l[1]; i++)
            result *= a[i];
    else
        for (i = l[0] - 1; i > l[1]; i--)
            result *= a[i];
    cout << result;  // Вывод сообщения
    delete[]a;
    return 0;
}