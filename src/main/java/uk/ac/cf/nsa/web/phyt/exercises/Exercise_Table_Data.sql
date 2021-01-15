INSERT INTO User (first_name, last_name, user_role, email, user_name, user_password) VALUES ('Joe', 'Bloggs', 'Trainer', 'joebloggs@email.com', 'trainer', 'password');
INSERT INTO User (first_name, last_name, user_role, email, user_name, user_password) VALUES ('Tracy', 'Smith', 'Trainer', 'tsmith@email.com', 'trainer2', 'password2');
INSERT INTO User (first_name, last_name, user_role, email, trainer_id, user_name, user_password) VALUES ('Jane', 'Doe', 'Client', 'joedoe@email.com', 1,'client', 'password1');

INSERT INTO Exercises(trainer_id, exercise_name, exercise_desc, category) VALUES (1, 'Plank', 'Select a place where you can extend your whole body length. Using an exercise mat will give you enough padding to be comfortable on all fours.
Begin in the plank position, face down with your forearms and toes on the floor. Your elbows are directly under your shoulders and your forearms are facing forward. Your head is relaxed and you should be looking at the floor.
Engage your abdominal muscles, drawing your navel toward your spine. Keep your torso straight and rigid and your body in a straight line from ears to toes with no sagging or bending. This is the neutral spine position. Ensure your shoulders are down, not creeping up toward your ears. Your heels should be over the balls of your feet.
Hold this position for 10 seconds. Release to floor.  Over time work up to 30, 45, or 60 seconds.', 'Core' );

INSERT INTO Exercises(trainer_id, exercise_name, exercise_desc, category) VALUES (1, 'Deadlift', 'Bend at the waist and at the knees equally and at the same time. Grasp the bar fully and securely in an overgrip or an alternate under/over grip about waist width (may be up to six inches wider for comfort). Looking straight ahead, your spine in a powerful flat position (not stooped over or rounded), focus, regulate your breathing, breath in deeply and steadily pull the bar to a full military position. Keep the bar close to the body and exhale as full force is exerted. Pause for a second of contraction and slowly bend your knees and low back as you return to the starting position and repeat. ', 'Lower body' );

INSERT INTO Exercises(trainer_id, exercise_name, exercise_desc, category) VALUES (1, 'Squat', 'Stand with feet shoulder-width apart, toes pointed out. Send hips back to squat down until thighs are at least parallel to floor while keeping chest lifted. Stand back up to start and repeat.', 'Lower body');

INSERT INTO Media (img_src, alt_text, type, exercise_id) VALUES ('/images/ExerciseThumbnail/plank.jpg', 'Lady doing a plank', 'Image', 1);
INSERT INTO Media (img_src, alt_text, type, exercise_id) VALUES ('/images/ExerciseThumbnail/deadlift.jpg', 'Man doing a deadlift', 'Image', 2);
INSERT INTO Media (img_src, alt_text, type, exercise_id) VALUES ('/images/ExerciseThumbnail/squat.jpg', 'Man doing a squat', 'Image', 3);

Update Exercises Set thumbnail_img='/images/ExerciseThumbnail/plank.jpg', thumbnail_alt='Lady doing a plank' WHERE id=1;
Update Exercises Set thumbnail_img='/images/ExerciseThumbnail/deadlift.jpg' ,thumbnail_alt='Man doing a deadlift' WHERE id=2;
Update Exercises Set thumbnail_img='/images/ExerciseThumbnail/squat.jpg' , thumbnail_alt='Man doing a squat' WHERE id=3;

INSERT INTO phyt.media (img_src, alt_text, type, exercise_id) VALUES ("https://www.youtube.com/embed/IiGk8g3e41w", "Video of how to deadlife", 'Video', 2);
INSERT INTO phyt.media (img_src, alt_text, type, exercise_id) VALUES ("https://www.youtube.com/embed/ASdvN_XEl_c", "Video of how to do a plank", 'Video', 1);
INSERT INTO phyt.media (img_src, alt_text, type, exercise_id) VALUES ("https://www.youtube.com/embed/aclHkVaku9U", "Video of how to squat", 'Video', 3);
INSERT INTO phyt.media (img_src, alt_text, type, exercise_id) VALUES ("/images/ExerciseThumbnail/plank2.jpg", "Lady doing plank", 'Image', 1);
INSERT INTO phyt.media (img_src, alt_text, type, exercise_id) VALUES ("/images/ExerciseThumbnail/deadlift2.jpg", "Image of a deadlift", 'Image', 2);