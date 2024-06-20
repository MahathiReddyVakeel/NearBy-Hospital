//Snippet code of Add Hospital:
protected void onCreate(@Nullable Bundle savedInstanceState) {
super.onCreate(savedInstanceState);
setContentView(R.layout.activity_add_hospital);
imageView=findViewById(R.id.map);
etlocation=findViewById(R.id.emap);
ethostelname=findViewById(R.id.ethostelname);
etfaci=findViewById(R.id.etwebsite);
btadd=findViewById(R.id.btadd);
storageReference= FirebaseStorage.getInstance().getReference();
ActivityCompat.requestPermissions(AddHospital.this,new
String[]{Manifest.permission.ACCESS_FINE_LOCATION,Manifest.permission.ACCESS_
COARSE_LOCATION},REQUEST_LOCATION_CODE);
imageView.setOnClickListener(new View.OnClickListener() {
@Override
public void onClick(View v) {
Intent intent=new Intent(AddHospital.this,MapsActivity2.class);
startActivityForResult(intent, 2);// Activity is started with requestCode 2
}
});
btadd.setOnClickListener(new View.OnClickListener() {
@Override
public void onClick(View v) {
String hospitalname=ethostelname.getText().toString();
String faci=etfaci.getText().toString();
String location=etlocation.getText().toString();
if(hospitalname.isEmpty() || hospitalname == null) {
ethostelname.setError("Enter Username");
} else if (faci.isEmpty() || faci == null) {
etfaci.setError("Password required");
} else if(location.isEmpty() || location == null){
etlocation.setError("Password required");
} else {
HashMap map = Store.getUserDetails(getApplicationContext());
Log.e("user key is", map.get("userid").toString());
mDatabase = FirebaseDatabase.getInstance().getReference("nearhospital");
userId = mDatabase.push().getKey();
Hospital user = new Hospital(hospitalname, location, faci);
mDatabase.child(userId).setValue(user);
addUserChangeListener();
}
}
});