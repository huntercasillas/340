//
//  User.swift
//  Carbon
//
//  Created by Hunter Casillas on 9/16/19.
//  Copyright © 2019 Hunter Casillas. All rights reserved.
//

import Foundation
import UIKit

public class User {
    
    var firstName: String
    var lastName: String
    var handle: String
    var password: String
    var email: String
    var avitar: UIImage
    
    init (firstName: String, lastName: String, handle: String, password: String, email: String,
          avitar: UIImage) {
        
        self.firstName = firstName
        self.lastName = lastName
        self.handle = handle
        self.password = password
        self.email = email
        self.avitar = avitar
    }
}
