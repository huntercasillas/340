//
//  LoginViewController.swift
//  Carbon
//
//  Created by Hunter Casillas on 9/16/19.
//  Copyright © 2019 Hunter Casillas. All rights reserved.
//

import UIKit

class LoginViewController: UIViewController, UITextFieldDelegate {
    
    override func viewDidLoad() {
        super.viewDidLoad()
        navigationItem.backBarButtonItem = UIBarButtonItem(title: "", style: .plain, target: nil, action: nil)
        loginButton.sizeToFit()
        userNameField.delegate = self
        passwordField.delegate = self
        // Do any additional setup after loading the view, typically from a nib.
    }
    
    let loginIndicator = ProgressLight(text: "Logging In...")
    var userName = ""
    var password = ""
    
    var authToken: String = "auth"
    var mainPersonID: String = "person"
    var mainUserName: String = "name"
    var mainFirstName: String = "first"
    var mainLastName: String = "last"
    var defaultImage = UIImage(named: "Avitar")
    
    @IBOutlet var userTextFields: [UITextField]!
    @IBOutlet weak var userNameField: UITextField!
    @IBOutlet weak var passwordField: UITextField!
    
    @IBOutlet weak var loginButton: UIButton!
    @IBAction func loginAction(_ sender: UIButton) {
        loginUser()
    }
    
    func textFieldShouldReturn(_ textField: UITextField) -> Bool {
        if textField == userNameField {
            textField.resignFirstResponder()
            passwordField.becomeFirstResponder()
        } else if textField == passwordField {
            textField.resignFirstResponder()
            self.view.endEditing(true)
            //loginUser()
        }
        return true
    }
    
    func loginUser() {
        userName = userNameField.text!
        userName = userName.trimmingCharacters(in: .whitespacesAndNewlines)
        password = passwordField.text!
        password = password.trimmingCharacters(in: .whitespacesAndNewlines)
        
        if (userName.count < 1 || password.count < 1) {
            loginError()
        } else {
            loginSuccess()
        }
    }
    
    func loginError() {
        view.endEditing(true)
        let errorMessage = UIAlertController(title: "Please be sure all required information is filled in.", message: nil, preferredStyle: .alert)
        errorMessage.addAction(UIAlertAction(title: "Try Again", style: .default, handler: { (action) in
        }))
        present(errorMessage, animated: true, completion: nil)
    }
    
    func loginSuccess() {
        // Dismiss keyboard and add loading indicator
        view.endEditing(true)
        self.view.addSubview(loginIndicator)
        
        // Create a new user/session (won't actually do this - this is only for the 340 assignment)
        let currentUser = User(firstName: "Blank", lastName: "User", handle: userName, password: password, email: "blank@email.com", avitar: defaultImage!)
        
        // Display loading indicator for 1 second then show message saying the user has logged in.
        DispatchQueue.main.asyncAfter(deadline: .now() + .seconds(1), execute: {
            self.loginIndicator.removeFromSuperview()
            let errorMessage = UIAlertController(title: "\(currentUser.handle) is logged in.", message: nil, preferredStyle: .alert)
            errorMessage.addAction(UIAlertAction(title: "Done", style: .default, handler: { (action) in
            }))
            self.present(errorMessage, animated: true, completion: nil)
        })
    }
}
