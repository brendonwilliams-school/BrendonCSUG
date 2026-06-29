#include <iostream>
#include <string>

using namespace std;

int main()
{
    string firstString;
    string secondString;
    string combinedString;

    for (int i = 1; i <= 3; i++)
    {
        cout << "\nString Entry #" << i << endl;

        cout << "Enter the first string: ";
        getline(cin, firstString);

        cout << "Enter the second string: ";
        getline(cin, secondString);

        combinedString = firstString + secondString;

        cout << "Concatenated result: " << combinedString << endl;
    }

    return 0;
}