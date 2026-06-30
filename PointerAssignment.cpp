#include <iostream>

using namespace std;

int main()
{
    // Declare regular integer variables
    int num1, num2, num3;

    // Create integer pointers with dynamic memory allocation
    int* ptr1 = new int;
    int* ptr2 = new int;
    int* ptr3 = new int;

    // Get user input
    cout << "Enter the first integer: ";
    cin >> num1;

    cout << "Enter the second integer: ";
    cin >> num2;

    cout << "Enter the third integer: ";
    cin >> num3;

    // Store values in dynamically allocated memory
    *ptr1 = num1;
    *ptr2 = num2;
    *ptr3 = num3;

    // Display variable values
    cout << "\nVariable Values:" << endl;
    cout << "num1 = " << num1 << endl;
    cout << "num2 = " << num2 << endl;
    cout << "num3 = " << num3 << endl;

    // Display values stored through pointers
    cout << "\nPointer Values:" << endl;
    cout << "*ptr1 = " << *ptr1 << endl;
    cout << "*ptr2 = " << *ptr2 << endl;
    cout << "*ptr3 = " << *ptr3 << endl;

    // Display memory addresses
    cout << "\nMemory Addresses:" << endl;
    cout << "ptr1 = " << ptr1 << endl;
    cout << "ptr2 = " << ptr2 << endl;
    cout << "ptr3 = " << ptr3 << endl;

    // Free dynamically allocated memory
    delete ptr1;
    delete ptr2;
    delete ptr3;

    // Set pointers to nullptr
    ptr1 = nullptr;
    ptr2 = nullptr;
    ptr3 = nullptr;

    cout << "\nMemory has been released successfully." << endl;

    return 0;
}