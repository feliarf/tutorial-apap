#Tutorial 9
1. Ceritakan langkah - langkah yang kalian lakukan untuk solve LATIHAN no.1, dan
mengapa kalian melakukan langkah - langkah tersebut?
    - langkah yang dilakukan untuk mengerjakan latihan 1 adalah dengan mengubah method async addStore. Pada method 
    tersebut, saya menambahkan line this.setState({nama:"", followers:"", keterangan:""});.
    Maksud dari line tersebut adalah mengubah state nama, followers, dan keterangan yang telah terupdate
    menjadi suatu string kosong. Dengan mengubah state tersebut maka form untuk addStore tidak berisi isian yang 
    sebelumnya telah diinput.
 
2. Jelaskan fungsi dari async dan await!
    - Fungsi dari async adalah untuk menjalankan suatu fungsi bersamaan dengan javascript (dapat 
    dilakukan secara bersamaan dengan tahapan lain). Sedangkan untuk await biasanya terdapat di
    dalam fungsi async, untuk await mengartikan bahwa untuk berhenti dari fungsi async terlebih
    dahulu sampai task selesai dilakukan. 
    
3. Masukkan jawaban dari TODO pada Component Lifecycle pada pertanyaan ini.
    - langkah 1
    >![](https://i.ibb.co/t4BKpjH/1.png)

    - langkah 2
    >![](https://i.ibb.co/8dCwTdF/2.png)

    - langkah 3
    >![](https://i.ibb.co/2WYbyg6/3.png)

    - langkah 4
    >![](https://i.ibb.co/rvjxsQv/4.png)

    - langkah 5
    >![](https://i.ibb.co/Brv74Bk/5.png)

    - langkah 6
    >![](https://i.ibb.co/SdSnD75/6.png)

    - langkah 7
    >![](https://i.ibb.co/cxKHHK6/7.png)

    - langkah 8
    >![](https://i.ibb.co/d7NChZz/8.png)

4. Jelaskan fungsi dari componentDidMount, shouldComponentUpdate,
componentDidUpdate, componentWillReceiveProps,
componentWillUnmount.
Notes : Penjelasan harus mencantumkan “kapan fungsi dipanggil” dan “use case apa saja
yang biasanya menggunakan lifecycle method tersebut”.
- componentDidMount :digunakan pada saat fungsi render() sudah dijalankan dan komponen telah
dipasang ke DOM. Use case yang menggunakan method ini adalah ketika fetch() ke server atau setState()
dari suatu state yang nantinya melakukan render
    
- shouldComponentUpdate : digunakan untuk menentukan apakah suatu state dapat diubah atau tidak berdasarkan state 
yg akan diubah. Fungsi ini juga biasanya digunakan untuk performance optimisation mesasures. Use case yang
menggunakan method ini ketika melakukan pengecekan state saat ini dengan yg akan diubah.

- componentDidUpdate : digunakan ketika state baru saja diubah. fungsi ini
juga dapat digunakan untuk mengoperasikan dom ketika komponen sudah diupdate.
Use case yang dapat menggunakan ini adalah ketika melakukan newtork request.

- componentWillReceiveProps: digunakan sebelum mounted component menerima props yang baru. Fungsi ini digunakan saat 
ingin melakukan setState terhadap perubahan props. Fungsi ini dijalankan ketika terjadi update pada props saja. 
 use case yang menggunakan ini adalah setState()
 
- componentWillUnmount: digunakan ketika component diunmount atau didestroy. Use
case yang menggunakan ini adalah untuk cleanup seperti invalidating timers, canceling network 
request atau cleaning up terhadap subscription yang dibuat di componentDidMount


This project was bootstrapped with [Create React App](https://github.com/facebook/create-react-app).

## Available Scripts

In the project directory, you can run:

### `npm start`

Runs the app in the development mode.<br />
Open [http://localhost:3000](http://localhost:3000) to view it in the browser.

The page will reload if you make edits.<br />
You will also see any lint errors in the console.

### `npm test`

Launches the test runner in the interactive watch mode.<br />
See the section about [running tests](https://facebook.github.io/create-react-app/docs/running-tests) for more information.

### `npm run build`

Builds the app for production to the `build` folder.<br />
It correctly bundles React in production mode and optimizes the build for the best performance.

The build is minified and the filenames include the hashes.<br />
Your app is ready to be deployed!

See the section about [deployment](https://facebook.github.io/create-react-app/docs/deployment) for more information.

### `npm run eject`

**Note: this is a one-way operation. Once you `eject`, you can’t go back!**

If you aren’t satisfied with the build tool and configuration choices, you can `eject` at any time. This command will remove the single build dependency from your project.

Instead, it will copy all the configuration files and the transitive dependencies (Webpack, Babel, ESLint, etc) right into your project so you have full control over them. All of the commands except `eject` will still work, but they will point to the copied scripts so you can tweak them. At this point you’re on your own.

You don’t have to ever use `eject`. The curated feature set is suitable for small and middle deployments, and you shouldn’t feel obligated to use this feature. However we understand that this tool wouldn’t be useful if you couldn’t customize it when you are ready for it.

## Learn More

You can learn more in the [Create React App documentation](https://facebook.github.io/create-react-app/docs/getting-started).

To learn React, check out the [React documentation](https://reactjs.org/).

### Code Splitting

This section has moved here: https://facebook.github.io/create-react-app/docs/code-splitting

### Analyzing the Bundle Size

This section has moved here: https://facebook.github.io/create-react-app/docs/analyzing-the-bundle-size

### Making a Progressive Web App

This section has moved here: https://facebook.github.io/create-react-app/docs/making-a-progressive-web-app

### Advanced Configuration

This section has moved here: https://facebook.github.io/create-react-app/docs/advanced-configuration

### Deployment

This section has moved here: https://facebook.github.io/create-react-app/docs/deployment

### `npm run build` fails to minify

This section has moved here: https://facebook.github.io/create-react-app/docs/troubleshooting#npm-run-build-fails-to-minify
