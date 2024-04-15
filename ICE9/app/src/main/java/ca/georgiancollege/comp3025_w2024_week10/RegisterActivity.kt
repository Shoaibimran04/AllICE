package ca.georgiancollege.comp3025_w2024_week10

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import ca.georgiancollege.comp3025_w2024_week10.databinding.ActivityRegisterBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.UserProfileChangeRequest

class RegisterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterBinding
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Initialize Firebase Auth
        auth = FirebaseAuth.getInstance()

        binding.CancelButton.setOnClickListener {
            finish()
        }

        binding.RegisterButton.setOnClickListener {
            val email = binding.EmailEditText.text.toString()
            val password = binding.PasswordText.text.toString()
            val username = binding.UsernameText.text.toString()

            registerUser(email, password, username)
        }
    }

    private fun registerUser(email: String, password: String, username: String) {
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Sign up success, update UI with the signed-in user's information
                    val user = auth.currentUser
                    val profileUpdates = UserProfileChangeRequest.Builder()
                        .setDisplayName(username)
                        .build()

                    user?.updateProfile(profileUpdates)
                        ?.addOnCompleteListener { updateProfileTask ->
                            if (updateProfileTask.isSuccessful) {
                                Toast.makeText(
                                    this@RegisterActivity,
                                    "Registration successful",
                                    Toast.LENGTH_SHORT
                                ).show()
                                println("User Registration Successful")
                                Log.d("RegisterActivity", "User Registered Successful")
                                Log.d("RegisterActivity", "User Email: $email")
                                finish() // Finish the activity and go back to the login screen
                            } else {
                                Toast.makeText(
                                    this@RegisterActivity,
                                    "Failed to update profile",
                                    Toast.LENGTH_SHORT
                                ).show()
                            }
                        }
                } else {
                    // If sign up fails, display a message to the user.
                    Toast.makeText(
                        baseContext, "Registration failed.",
                        Toast.LENGTH_SHORT
                    ).show()
                    // Update UI accordingly
                }
            }
    }
}
