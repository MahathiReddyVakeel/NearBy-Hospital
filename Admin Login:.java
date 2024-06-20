#Snippet code of Admin Login:
public class AdminSuccessLogin extends AppCompatActivity {
Button btaddhospital,btviewhospital,btlogout;
@Override
protected void onCreate(@Nullable Bundle savedInstanceState) {
super.onCreate(savedInstanceState);
setContentView(R.layout.activity_admin_login);
btaddhospital=findViewById(R.id.btaddhospital);
btviewhospital=findViewById(R.id.btviewhospital);
btlogout=findViewById(R.id.btlogout);
btaddhospital.setOnClickListener(new View.OnClickListener() {
@Override
public void onClick(View view) {
Intent i=new Intent(getApplicationContext(),AddHospital.class);
startActivity(i);
}
});
btviewhospital.setOnClickListener(new View.OnClickListener() {
@Override
public void onClick(View view) {
startActivity(new Intent(getApplicationContext(),ViewHospital.class));
}
});
btlogout.setOnClickListener(new View.OnClickListener() {
@Override
public void onClick(View view) {
startActivity(new Intent(getApplicationContext(),MainActivity.class));
finish();
}
}); }
}