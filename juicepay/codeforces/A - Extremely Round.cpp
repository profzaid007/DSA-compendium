#include <iostream>
#include <string>
using namespace std;

#define int long long
#define sz(x) (int)(x).size()
#define FAST_IO ios::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL)

void solve()
{
    string n;
    cin >> n;
    cout << 9 * (sz(n) - 1) + n[0] - '0' << endl;
}

int32_t main()
{
    FAST_IO;
    int TC = 1;
    cin >> TC;
    while (TC--) 
        solve();
    return 0;
}
