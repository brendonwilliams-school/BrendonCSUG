#include <iostream>
#include <fstream>
#include <string>
#include <algorithm>
#include <iterator>

using namespace std;

/*
 * Appends user input to the original text file.
 */
bool appendUserInput(const string& fileName, const string& userInput) {
    ofstream outputFile(fileName, ios::app);

    if (!outputFile.is_open()) {
        cerr << "Error: Could not open " << fileName
             << " for appending." << endl;
        return false;
    }

    // Add a newline before the new text so it does not run
    // together with existing content.
    outputFile << endl << userInput;

    outputFile.close();
    return true;
}

/*
 * Reads all characters from the original file, reverses them,
 * and writes the reversed content to a new file.
 */
bool reverseFileContents(const string& inputFileName,
                         const string& outputFileName) {

    ifstream inputFile(inputFileName, ios::binary);

    if (!inputFile.is_open()) {
        cerr << "Error: Could not open " << inputFileName
             << " for reading." << endl;
        return false;
    }

    string fileContents(
        (istreambuf_iterator<char>(inputFile)),
        istreambuf_iterator<char>()
    );

    inputFile.close();

    reverse(fileContents.begin(), fileContents.end());

    ofstream outputFile(outputFileName, ios::binary);

    if (!outputFile.is_open()) {
        cerr << "Error: Could not open " << outputFileName
             << " for writing." << endl;
        return false;
    }

    outputFile << fileContents;
    outputFile.close();

    return true;
}

int main() {
    const string originalFileName = "CSC450_CT5_mod5.txt";
    const string reversedFileName = "CSC450-mod5-reverse.txt";

    string userInput;

    cout << "CSC450 Module 5 User Input Program" << endl;
    cout << "----------------------------------" << endl;
    cout << "Enter text to append to the file:" << endl;

    getline(cin, userInput);

    if (userInput.empty()) {
        cout << "No text was entered. The file was not changed." << endl;
        return 0;
    }

    if (!appendUserInput(originalFileName, userInput)) {
        return 1;
    }

    cout << endl;
    cout << "Your text was successfully appended to "
         << originalFileName << "." << endl;

    if (!reverseFileContents(originalFileName, reversedFileName)) {
        return 1;
    }

    cout << "The complete file contents were reversed and saved to "
         << reversedFileName << "." << endl;

    cout << endl;
    cout << "Program completed successfully." << endl;

    return 0;
}
