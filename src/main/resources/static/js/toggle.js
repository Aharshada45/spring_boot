var users = [
  {
    name: "John Doe",
    gender: "Male",
    image: "../images/john.png",
  },
  {
    name: "Jane Smith",
    gender: "Female",
    image: "../images/jane.png",
  },
];

var id = 0;
function toggle() {
  id = (id + 1) % users.length;
  var user = users[id];
  console.log(user);
  document.getElementById("user-name").innerHTML = user.name;
  document.getElementById("user-gender").innerText = user.gender;
  document.getElementById("user-image").src = user.image;
}
